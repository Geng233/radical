package fun.yunblog.radical.web.controller;

import com.alibaba.fastjson.JSON;
import fun.yunblog.radical.model.domain.Attachment;
import fun.yunblog.radical.model.response.Result;
import fun.yunblog.radical.service.AttachmentService;
import fun.yunblog.radical.util.RadicalUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;

/**
 * @author 耿子云
 * @date 2021/10/8
 */
@RestController
@RequestMapping("/attachment")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;

    @ApiOperation("上传附件")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadResource(@RequestParam(required = true) MultipartFile file) {
        try {
            byte[] fileBytes = file.getBytes();
            byte[] narrowFileBytes = RadicalUtil.getNarrowFile(file);
            Attachment attachment = new Attachment();
            attachment.setAnnex(fileBytes);
            attachment.setAnnexNarrow(narrowFileBytes);
            attachment.setAttachmentName(file.getResource().getFilename());
            attachment.setCreateData(new Date());
            boolean res = attachmentService.addAttachment(attachment);
            if (res) {
                return JSON.toJSONString(new Result().setCode(200).setMessage("保存附件失败"));
            } else {
                return JSON.toJSONString(new Result().setCode(400).setMessage("保存附件失败"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    @ApiOperation("获取附件")
//    @RequestMapping(value = "/get/{attachmentName}")
//    public void getResource(@PathVariable String attachmentName, HttpServletResponse response) {
//        System.out.println("attachmentName------------------" + attachmentName);
//        System.out.println("response------------------" + response);
////        b = attachmentService.queryAttachmentAnnexNarrow(attachmentName);
//        byte[] b = attachmentService.queryAttachment(attachmentName).getAnnexNarrow();
//        InputStream is = new ByteArrayInputStream(b);
//        response.setContentType("image/*");
//        try {
//            ServletOutputStream out = response.getOutputStream();
//            int len = 0;
//            byte[] buf = new byte[1024];
//            while ((len - is.read(buf, 0, 1024)) != -1) {
//                out.write(buf, 0, len);
//            }
//            out.flush();
//            out.close();
//            System.out.println("close --------------");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}

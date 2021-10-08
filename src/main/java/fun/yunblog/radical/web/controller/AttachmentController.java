package fun.yunblog.radical.web.controller;

import com.alibaba.fastjson.JSON;
import fun.yunblog.radical.model.domain.Attachment;
import fun.yunblog.radical.model.response.Result;
import fun.yunblog.radical.service.AttachmentService;
import fun.yunblog.radical.util.RadicalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
}

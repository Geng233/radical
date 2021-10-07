package fun.yunblog.radical.web.controller;

import com.alibaba.fastjson.JSON;
import fun.yunblog.radical.model.response.Result;
import fun.yunblog.radical.service.OptionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author 耿子云
 * @date 2021/10/5
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private OptionService optionService;

    @ApiOperation("获取index页面信息")
    @RequestMapping(value = "/indexInfo", method = RequestMethod.GET)
    public String getIndexInfo() {
        try {
            HashMap<String, Object> map = new HashMap<>();
            String displayName = optionService.queryOptionValueByOptionName("display-name");
            String noticeBoard = optionService.queryOptionValueByOptionName("notice-board");
            map.put("displayName", displayName);
            map.put("noticeBoard", noticeBoard);
            return JSON.toJSONStringWithDateFormat(new Result().setCode(200).setMessage("获取index页面信息成功").setData(map), "yyyy-MM-dd  HH:mm:ss");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(new Result().setCode(400).setMessage("获取index页面信息成功"));
    }

}

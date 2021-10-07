package fun.yunblog.radical.web.controller;

import com.alibaba.fastjson.JSON;
import fun.yunblog.radical.model.domain.Option;
import fun.yunblog.radical.model.response.Result;
import fun.yunblog.radical.service.OptionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 耿子云
 * @date 2021/10/3
 */
@RestController
@RequestMapping("/option")
public class OptionController {

    @Autowired
    private OptionService optionService;

    @ApiOperation("获取所有设置项")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getAllOption() {
        List<Option> options = optionService.queryAllOption();
        if (options == null) {
            return JSON.toJSONString(new Result().setCode(400).setMessage("查找设置项失败"));
        } else {
            return JSON.toJSONString(new Result().setCode(200).setMessage("查找设置项成功").setData(options));
        }
    }

}

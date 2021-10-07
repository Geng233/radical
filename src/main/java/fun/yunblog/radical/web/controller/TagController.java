package fun.yunblog.radical.web.controller;

import com.alibaba.fastjson.JSON;
import fun.yunblog.radical.model.domain.Tag;
import fun.yunblog.radical.model.response.Result;
import fun.yunblog.radical.service.TagService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 耿子云
 * @date 2021/9/29
 */
@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;


    @ApiOperation("添加标签")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addTag(@RequestBody Tag tag) {
        boolean res = tagService.addTag(tag);
        if (res) {
            return JSON.toJSONString(new Result().setCode(200).setMessage("添加成功"));
        } else {
            return JSON.toJSONString(new Result().setCode(400).setMessage("添加失败"));
        }
    }

    @ApiOperation("删除标签")
    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public String removeTag(Long tagId) {
        boolean res = tagService.removeTag(tagId);
        if (res) {
            return JSON.toJSONString(new Result().setCode(200).setMessage("删除成功"));
        } else {
            return JSON.toJSONString(new Result().setCode(400).setMessage("删除失败"));
        }
    }

    @ApiOperation("修改标签")
    @RequestMapping(value = "/alter", method = RequestMethod.PUT)
    public String alterTag(@RequestBody Tag tag) {
        boolean res = tagService.alterTag(tag);
        if (res) {
            return JSON.toJSONString(new Result().setCode(200).setMessage("更改成功"));
        } else {
            return JSON.toJSONString(new Result().setCode(400).setMessage("更改失败"));
        }
    }

    @ApiOperation("获取所有标签")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getTag() {
        List<Tag> tags = tagService.queryAllTag();
        return JSON.toJSONString(new Result().setCode(200).setMessage("查询成功").setData(tags));
    }
}

package fun.yunblog.radical.web.controller;

import com.alibaba.fastjson.JSON;
import fun.yunblog.radical.model.domain.Category;
import fun.yunblog.radical.model.response.Result;
import fun.yunblog.radical.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 耿子云
 * @date 2021/9/29
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @ApiOperation("添加标签")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCategory(@RequestBody Category category) {
        boolean res = categoryService.addCategory(category);
        if (res) {
            return JSON.toJSONString(new Result().setCode(200).setMessage("添加成功"));
        } else {
            return JSON.toJSONString(new Result().setCode(400).setMessage("添加失败"));
        }
    }

    @ApiOperation("删除标签")
    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public String removeCategory(Long categoryId) {
        boolean res = categoryService.removeCategory(categoryId);
        if (res) {
            return JSON.toJSONString(new Result().setCode(200).setMessage("删除成功"));
        } else {
            return JSON.toJSONString(new Result().setCode(400).setMessage("删除失败"));
        }
    }

    @ApiOperation("修改标签")
    @RequestMapping(value = "/alter", method = RequestMethod.PUT)
    public String alterCategory(@RequestBody Category category) {
        boolean res = categoryService.alterCategory(category);
        if (res) {
            return JSON.toJSONString(new Result().setCode(200).setMessage("更改成功"));
        } else {
            return JSON.toJSONString(new Result().setCode(400).setMessage("更改失败"));
        }
    }

    @ApiOperation("获取所有标签")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getCategory() {
        List<Category> categories = categoryService.queryAllCategory();
        return JSON.toJSONString(new Result().setCode(200).setMessage("查询成功").setData(categories));
    }
}

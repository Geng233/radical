package fun.yunblog.radical.web.controller;

import com.alibaba.fastjson.JSON;
import fun.yunblog.radical.model.domain.Article;
import fun.yunblog.radical.model.response.Result;
import fun.yunblog.radical.service.ArticleService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

/**
 * @author 耿子云
 * @date 2021/9/27
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ApiOperation("添加文章")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addArticle(@RequestBody Article article) {
        if (StringUtils.isEmpty(article.getArticleTitle()) || StringUtils.isEmpty(article.getArticleType())
                || article.getArticleCreateDate() == null || article.getArticleUpdateDate() == null) {
            return JSON.toJSONString(new Result().setCode(400).setMessage("提交表单错误"));
        }
        boolean res = articleService.addArticle(article);
        if (res) {
            return JSON.toJSONString(new Result().setCode(200).setMessage("添加成功"));
        } else {
            return JSON.toJSONString(new Result().setCode(400).setMessage("添加失败"));
        }
    }

    @ApiOperation("添加文章标签")
    @RequestMapping(value = "/addTag", method = RequestMethod.POST)
    public String addArticleTag(@RequestBody Map<String, Long> map) {
        boolean res = articleService.addArticleTag(map.get("articleId"), map.get("tagId"));
        if (res) {
            return JSON.toJSONString(new Result().setCode(200).setMessage("添加标签成功"));
        } else {
            return JSON.toJSONString(new Result().setCode(400).setMessage("添加标签失败"));
        }
    }

    @ApiOperation("添加文章目录")
    @RequestMapping(value = "/addCategory", method = RequestMethod.POST)
    public String addArticleCategory(@RequestBody Map<String, Long> map) {
        boolean res = articleService.addArticleCategory(map.get("articleId"), map.get("categoryId"));
        if (res) {
            return JSON.toJSONString(new Result().setCode(200).setMessage("添加目录成功"));
        } else {
            return JSON.toJSONString(new Result().setCode(400).setMessage("添加目录失败"));
        }
    }

    @ApiOperation("删除文章")
    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public String deleteArticle(Long articleId) {
        boolean res = articleService.removeArticle(articleId);
        if (res) {
            return JSON.toJSONString(new Result().setCode(200).setMessage("删除成功"));
        } else {
            return JSON.toJSONString(new Result().setCode(400).setMessage("删除失败"));
        }
    }

    @ApiOperation("删除文章标签")
    @RequestMapping(value = "/removeTag", method = RequestMethod.DELETE)
    public String deleteArticleTag(Long articleId, Long tagId) {
        boolean res = articleService.removeArticleTag(articleId, tagId);
        if (res) {
            return JSON.toJSONString(new Result().setCode(200).setMessage("删除成功"));
        } else {
            return JSON.toJSONString(new Result().setCode(400).setMessage("删除失败"));
        }
    }

    @ApiOperation("删除文章目录")
    @RequestMapping(value = "/removeCategory", method = RequestMethod.DELETE)
    public String deleteArticleCategory(Long articleId, Long categoryId) {
        boolean res = articleService.removeArticleCategory(articleId, categoryId);
        if (res) {
            return JSON.toJSONString(new Result().setCode(200).setMessage("删除成功"));
        } else {
            return JSON.toJSONString(new Result().setCode(400).setMessage("删除失败"));
        }
    }


    @ApiOperation("更新文章")
    @RequestMapping(value = "/alter", method = RequestMethod.PUT)
    public String alterArticle(@RequestBody Article article) {
        boolean res = articleService.alterArticle(article);
        if (res) {
            return JSON.toJSONString(new Result().setCode(200).setMessage("更改成功"));
        } else {
            return JSON.toJSONString(new Result().setCode(400).setMessage("更改失败"));
        }
    }
    @ApiOperation("更新文章类型")
    @RequestMapping(value = "/alterType", method = RequestMethod.PUT)
    public String alterArticleType(@RequestBody Article article) {
        System.out.println(article);
        boolean res = articleService.alterArticleType(article.getArticleId(), article.getArticleType());
        if (res) {
            return JSON.toJSONString(new Result().setCode(200).setMessage("更改成功"));
        } else {
            return JSON.toJSONString(new Result().setCode(400).setMessage("更改失败"));
        }
    }

    @ApiOperation("查看文章,可以设置数目")
    @RequestMapping(value = "/getComplete", method = RequestMethod.GET)
    public String getAllArticleComplete(String userName, Long length) {
        List<Article> articles = articleService.queryArticlesComplete(userName, length);
        if (articles == null) {
            return JSON.toJSONString(new Result().setCode(400).setMessage("查询失败"));
        }
        return JSON.toJSONStringWithDateFormat(new Result().setCode(200).setMessage("查询成功").setData(articles),"yyyy-MM-dd  HH:mm:ss");
    }

    @ApiOperation("查看文章(没有tag和category信息)")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getAllArticle(String userName) {
        List<Article> articles = articleService.queryArticlesByUserName(userName);
        if (articles == null) {
            return JSON.toJSONString(new Result().setCode(400).setMessage("查询失败"));
        }
        return JSON.toJSONStringWithDateFormat(new Result().setCode(200).setMessage("查询成功").setData(articles),"yyyy-MM-dd  HH:mm:ss");
    }

    @ApiOperation("查看文章(没有页面内容)(没有tag和category信息),可以设置数目")
    @RequestMapping(value = "/getSimple", method = RequestMethod.GET)
    public String getAllArticleSimple(String userName, Long length) {
        List<Article> articles = articleService.queryArticlesSimple(userName, length);
        if (articles == null) {
            return JSON.toJSONString(new Result().setCode(400).setMessage("查询失败"));
        }
        return JSON.toJSONStringWithDateFormat(new Result().setCode(200).setMessage("查询成功").setData(articles),"yyyy-MM-dd  HH:mm:ss");
    }

    @ApiOperation("查看文章(没有页面内容),可以设置数目")
    @RequestMapping(value = "/getWithoutContent", method = RequestMethod.GET)
    public String getAllArticleWithoutContent(String userName, Long length) {
        List<Article> articles = articleService.queryArticleWithoutContent(userName, length);
        if (articles == null) {
            return JSON.toJSONString(new Result().setCode(400).setMessage("查询失败"));
        } else {
            return JSON.toJSONStringWithDateFormat(new Result().setCode(200).setMessage("查询成功").setData(articles),"yyyy-MM-dd  HH:mm:ss");
        }
    }

    @ApiOperation("根据articleId获取谋篇文章")
    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    public String getArticleByArticleId(Long articleId) {
        Article article = articleService.queryArticleByArticleId(articleId);
        if (article != null) {
            return JSON.toJSONStringWithDateFormat(new Result().setCode(200).setMessage("查询成功").setData(article),"yyyy-MM-dd  HH:mm:ss");
        } else {
            return JSON.toJSONString(new Result().setCode(400).setMessage("查询失败"));
        }
    }

    @ApiOperation("根据categoryId获取谋些文章")
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String getArticlesByCategoryId(Long categoryId) {
        List<Article> articles = articleService.queryArticlesByCategoryId(categoryId);
        if (articles == null) {
            return JSON.toJSONString(new Result().setCode(400).setMessage("查询失败"));
        } else {
            return JSON.toJSONStringWithDateFormat(new Result().setCode(200).setMessage("查询成功").setData(articles),"yyyy-MM-dd  HH:mm:ss");
        }
    }

    @ApiOperation("根据tagId获取谋些文章")
    @RequestMapping(value = "/tagId", method = RequestMethod.GET)
    public String getArticlesByTagId(Long tagId) {
        List<Article> articles = articleService.queryArticlesByTagId(tagId);
        if (articles == null) {
            return JSON.toJSONString(new Result().setCode(400).setMessage("查询失败"));
        } else {
            return JSON.toJSONStringWithDateFormat(new Result().setCode(200).setMessage("查询成功").setData(articles),"yyyy-MM-dd  HH:mm:ss");
        }
    }
}

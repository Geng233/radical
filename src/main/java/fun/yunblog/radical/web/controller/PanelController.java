package fun.yunblog.radical.web.controller;

import com.alibaba.fastjson.JSON;
import fun.yunblog.radical.mapper.ArticleMapper;
import fun.yunblog.radical.model.domain.Article;
import fun.yunblog.radical.model.domain.Option;
import fun.yunblog.radical.model.domain.User;
import fun.yunblog.radical.model.response.Result;
import fun.yunblog.radical.service.ArticleService;
import fun.yunblog.radical.service.OptionService;
import fun.yunblog.radical.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 耿子云
 * @date 2021/10/5
 */
@RestController
@RequestMapping("/panel")
public class PanelController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;
    @Autowired
    private OptionService optionService;

    @ApiOperation("获取仪表盘信息")
    @RequestMapping(value = "/panelInfo", method = RequestMethod.GET)
    public String getPanelInfo(String userName) {
        HashMap<String, Object> map = new HashMap<>();
        User user = userService.queryUserByUserName(userName);
        List<Article> articles = articleService.queryArticlesSimple(userName, null);
        int okSize = (int) articles.stream().filter(x -> "ok".equals(x.getArticleType())).count();
        int draftSize = (int) articles.stream().filter(x -> "draft".equals(x.getArticleType())).count();
        String blogCreateDate = optionService.queryOptionValueByOptionName("blog-create-date");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateTime = null;
        try {
            dateTime = simpleDateFormat.parse(blogCreateDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        map.put("loginLast", user.getUserLoginLast());
        map.put("articleOkSize", okSize);
        map.put("articleDraftSize", draftSize);
        map.put("blogCreateDate", dateTime);
        System.out.println(map);
        return JSON.toJSONStringWithDateFormat(new Result().setCode(200).setMessage("获取仪表盘信息成功").setData(map),"yyyy-MM-dd  HH:mm:ss");
    }
}

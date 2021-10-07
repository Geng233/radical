package fun.yunblog.radical.web.controller;

import com.alibaba.fastjson.JSON;
import fun.yunblog.radical.model.domain.Link;
import fun.yunblog.radical.model.response.Result;
import fun.yunblog.radical.service.LinkService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 耿子云
 * @date 2021/10/3
 */
@RestController
@RequestMapping("/link")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @ApiOperation("增加链接")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addLink(@RequestBody Link link) {
        boolean res = linkService.addLink(link);
        if (res) {
            return JSON.toJSONString(new Result().setCode(200).setMessage("添加成功"));
        } else {
            return JSON.toJSONString(new Result().setCode(400).setMessage("添加失败"));
        }
    }

    @ApiOperation("删除链接")
    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public String removeLink(Long linkId) {
        boolean res = linkService.removeLinkByLinkId(linkId);
        if (res) {
            return JSON.toJSONString(new Result().setCode(200).setMessage("删除成功"));
        } else {
            return JSON.toJSONString(new Result().setCode(400).setMessage("删除失败"));
        }
    }


    @ApiOperation("更改链接")
    @RequestMapping(value = "/alter", method = RequestMethod.PUT)
    public String alterLink(@RequestBody Link link) {
        if (link != null || link.getLinkId() != null) {
            boolean b = linkService.alterLink(link);
            if (b) {
                return JSON.toJSONString(new Result().setCode(200).setMessage("更改链接成功"));
            }
        }
        return JSON.toJSONString(new Result().setCode(400).setMessage("更改链接失败"));
    }


    @ApiOperation("查询所有链接")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getAllLink() {
        List<Link> links = linkService.queryAllLink();
        if (links == null) {
            return JSON.toJSONString(new Result().setCode(400).setMessage("查找链接失败"));
        } else {
            return JSON.toJSONString(new Result().setCode(200).setMessage("查找链接成功").setData(links));
        }
    }

}

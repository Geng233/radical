package fun.yunblog.radical.service.impl;

import fun.yunblog.radical.mapper.LinkMapper;
import fun.yunblog.radical.model.domain.Link;
import fun.yunblog.radical.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 耿子云
 * @date 2021/10/3
 */
@Service
public class LinkServiceImpl implements LinkService {


    @Autowired
    private LinkMapper linkMapper;

    @Override
    public List<Link> queryAllLink() {
        return linkMapper.selectAllLink();
    }

    @Override
    public Link queryLinkByLinkId(Long linkId) {
        return linkMapper.selectLinkByLinkId(linkId);
    }

    @Override
    public boolean alterLink(Link link) {
        return linkMapper.updateLink(link.getLinkId(), link.getLinkName(), link.getLinkUrl(), link.getLinkDescription(), link.getLinkPic(), link.getLinkState());
    }

    @Override
    public boolean removeLinkByLinkId(Long linkId) {
        return linkMapper.deleteLinkByLinkId(linkId);
    }

    @Override
    public boolean addLink(Link link) {
        return linkMapper.insertLink(link.getLinkId(), link.getLinkName(), link.getLinkUrl(), link.getLinkDescription(), link.getLinkPic(), link.getLinkState());
    }

}

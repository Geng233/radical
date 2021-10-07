package fun.yunblog.radical.service;

import fun.yunblog.radical.model.domain.Link;

import java.util.List;

/**
 * @author 耿子云
 * @date 2021/10/3
 */
public interface LinkService {

    List<Link> queryAllLink();

    Link queryLinkByLinkId(Long linkId);

    boolean alterLink(Link link);

    boolean removeLinkByLinkId(Long linkId);

    boolean addLink(Link link);
}

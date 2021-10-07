package fun.yunblog.radical.service;

import fun.yunblog.radical.model.domain.Tag;

import java.util.List;

/**
 * @author 耿子云
 * @date 2021/9/29
 */
public interface TagService {

    List<Tag> queryAllTagComplete();

    List<Tag> queryAllTag();

    Tag queryTagByTagId(Long tagId);

    Tag queryTagByTagName(String tagName);

    boolean addTag(Tag tag);

    boolean removeTag(Long tagId);

    boolean alterTag(Tag tag);
}

package fun.yunblog.radical.service.impl;

import fun.yunblog.radical.mapper.TagMapper;
import fun.yunblog.radical.model.domain.Tag;
import fun.yunblog.radical.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 耿子云
 * @date 2021/9/29
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Tag> queryAllTagComplete() {
        return tagMapper.selectAllTagComplete();
    }

    @Override
    public List<Tag> queryAllTag() {
        return tagMapper.selectAllTag();
    }

    @Override
    public Tag queryTagByTagId(Long tagId) {
        return tagMapper.selectTagByTagId(tagId);
    }

    @Override
    public Tag queryTagByTagName(String tagName) {
        return tagMapper.selectTagByTagName(tagName);
    }

    @Override
    public boolean addTag(Tag tag) {
        return tagMapper.insertTag(tag.getTagName(), tag.getTagUrl());
    }

    @Override
    public boolean removeTag(Long tagId) {
        return tagMapper.deleteTag(tagId);
    }

    @Override
    public boolean alterTag(Tag tag) {
        return tagMapper.updateTag(tag.getTagName(), tag.getTagUrl(), tag.getTagId());
    }
}

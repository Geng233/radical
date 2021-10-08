package fun.yunblog.radical.service.impl;

import fun.yunblog.radical.mapper.AttachmentMapper;
import fun.yunblog.radical.model.domain.Attachment;
import fun.yunblog.radical.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 耿子云
 * @date 2021/10/8
 */
@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    private AttachmentMapper attachmentMapper;

    @Override
    public Attachment queryAttachment(String attachmentName) {
        return null;
    }

    @Override
    public Attachment queryAttachment(Long attachmentId) {
        return null;
    }

    @Override
    public boolean addAttachment(Attachment attachment) {
        return attachmentMapper.insertAttachment(attachment);
    }
}

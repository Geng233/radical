package fun.yunblog.radical.service;

import fun.yunblog.radical.model.domain.Attachment;

/**
 * @author 耿子云
 * @date 2021/10/8
 */
public interface AttachmentService {

    public Attachment queryAttachment(String attachmentName);

    public Attachment queryAttachment(Long attachmentId);

    public boolean addAttachment(Attachment attachment);

    public byte[] queryAttachmentAnnexNarrow(String attachmentName);
}

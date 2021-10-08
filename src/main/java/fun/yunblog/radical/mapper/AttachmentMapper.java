package fun.yunblog.radical.mapper;

import fun.yunblog.radical.model.domain.Attachment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author 耿子云
 * @date 2021/10/8
 */
@Mapper
public interface AttachmentMapper {

    @Select("select * from attachment where attachmentId = #{attachmentId}")
    Attachment selectAttachmentById(Long attachmentId);

    @Select("select * from attachment where attachmentName = #{attachmentName}")
    Attachment selectAttachmentByName(String attachmentName);

    @Insert("insert into attachment (attachmentName, annex, annexNarrow, createData) values (#{attachmentName}, #{annex, jdbcType=BLOB}, #{annexNarrow, jdbcType=BLOB}, #{createData})")
    boolean insertAttachment(Attachment attachment);

}

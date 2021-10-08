package fun.yunblog.radical.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author 耿子云
 * @date 2021/10/8
 */
@ApiModel("附件")
@Data
public class Attachment {

    @ApiModelProperty("附件id")
    private Long attachmentId;

    @ApiModelProperty("附件名")
    private String attachmentName;

    @ApiModelProperty("附件")
    private byte[] annex;

    @ApiModelProperty("附件缩略图")
    private byte[] annexNarrow;

    @ApiModelProperty("附件创建时间")
    private Date createData;
}

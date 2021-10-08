package fun.yunblog.radical.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author 耿子云
 * @date 2021/10/8
 */
@ApiModel("评论实体")
@Data
public class Comment {

    @ApiModelProperty("评论id")
    private Long commentId;

    @ApiModelProperty("评论用户名    ")
    private String commentUserName;

    @ApiModelProperty("评论地址")
    private String commentUserEmail;

    @ApiModelProperty("评论用户ip")
    private String commentUserIp;

    @ApiModelProperty("评论内容")
    private String commentContent;

    @ApiModelProperty("评论日期")
    private Date commentDate;

    @ApiModelProperty("评论状态")
    private String commentState; //'ok' 'check' 'ban'
}

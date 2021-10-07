package fun.yunblog.radical.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 耿子云
 * @date 2021/10/3
 */
@ApiModel("链接")
@Data
public class Link {

    @ApiModelProperty("链接id")
    private Long linkId;

    @ApiModelProperty("链接名")
    private String linkName;

    @ApiModelProperty("链接url")
    private String linkUrl;

    @ApiModelProperty("链接描述")
    private String linkDescription;

    @ApiModelProperty("链接图片")
    private String linkPic;

    @ApiModelProperty("链接状态 ok -- 展示 ban -- 禁止 disable 链接地址不可用")
    private String linkState;
}

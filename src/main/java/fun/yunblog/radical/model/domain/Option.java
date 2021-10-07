package fun.yunblog.radical.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 耿子云
 * @date 2021/10/3
 */
@ApiModel("选项")
@Data
public class Option {
    @ApiModelProperty("选项id")
    private Long optionId;

    @ApiModelProperty("选项名称")
    private String  optionName;

    @ApiModelProperty("选项值")
    private String optionValue;
}

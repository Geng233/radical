package fun.yunblog.radical.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 耿子云
 * @date 2021/9/28
 * @Description 角色实体
 */
@Data
@ApiModel("角色实体")
public class Role {

    @ApiModelProperty("角色id")
    private Long roleId;

    @ApiModelProperty("角色名称")
    private String roleName;

}

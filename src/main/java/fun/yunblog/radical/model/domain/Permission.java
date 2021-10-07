package fun.yunblog.radical.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 耿子云
 * @date 2021/9/28
 * @Description 权限实体,也作为后台的菜单实体
 */
@Data
@ApiModel("权限实体")
public class Permission {

    @ApiModelProperty("权限id")
    private Long permissionId;

    @ApiModelProperty("权限名称")
    private String permissionName;

    @ApiModelProperty("权限代码")
    private String permissionCode;

    @ApiModelProperty("权限路径")
    private String permissionPath;

    @ApiModelProperty("父权限")
    private Long permissionFatherId;

    @ApiModelProperty("该权限为菜单否")
    private Long permissionIsMenu;
}

package fun.yunblog.radical.model.domain;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author 耿子云
 * @date 2021/9/26
 * @Description 用户实体
 */
@Data
@ApiModel("用户实体")
public class User {
    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("用户名称")
    private String userName;

    @ApiModelProperty("用户密码")
    private String password;

    @ApiModelProperty("加密的盐")
    private String salt;

    @ApiModelProperty("用户头像")
    private String userAvatar;

    @ApiModelProperty("用户Email")
    private String userEmail;

    @ApiModelProperty("用户描述 ")
    private String userDescription;

    @ApiModelProperty("最后登录时间")
    private Date userLoginLast;
}

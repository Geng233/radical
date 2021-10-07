package fun.yunblog.radical.realm;

import fun.yunblog.radical.model.domain.User;
import fun.yunblog.radical.service.PermissionService;
import fun.yunblog.radical.service.RoleService;
import fun.yunblog.radical.service.UserService;
import fun.yunblog.radical.model.token.JwtToken;
import fun.yunblog.radical.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author 耿子云
 * @date 2021/9/27
 * @Description AuthorizingRealm重写部分方法
 * * Authorization 授权 用法：@RequiresPermissions("permissionCode1")
 * * Authentication 身份验证
 */
@Component
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    /*
     * 判断是不是自定义的JwtToken
     * */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String userName = (String) principalCollection.iterator().next();
        Set<String> roles = roleService.queryRolesNameByUserName(userName);
        Set<String> permissions = permissionService.queryPermissionCodeByUserName(userName);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(permissions);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        JwtToken jwtToken = (JwtToken) token;
        String jwt = (String) jwtToken.getPrincipal();
        Claims claims = JwtUtil.parseJWT(jwt);
        String username = claims.getId();
        User user = userService.queryUserByUserName(username);
        if (user == null) {
            return null;
        }
        //此处需要自定义密码验证器
        return new SimpleAuthenticationInfo(username, user.getPassword(), getName());
    }
}

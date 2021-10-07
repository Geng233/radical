package fun.yunblog.radical.shiro;

import fun.yunblog.radical.model.domain.User;
import fun.yunblog.radical.service.UserService;
import fun.yunblog.radical.model.token.JwtToken;
import fun.yunblog.radical.util.StringUtil;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 耿子云
 * @date 2021/9/27
 * Description 自定义密码验证器，内涵密码验证逻辑
 */
@Component
public class MyCredentialsMatcher extends SimpleCredentialsMatcher {
    @Autowired
    private UserService userService;

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        JwtToken jwtToken = (JwtToken) token;
        // 有token没密码也通过
        if (jwtToken.getPassword() == null) {
            // 验证通过
            return true;
        }
        // 获取前端传来的密码
        String inPassword = new String(jwtToken.getPassword());
        // 获取前端传来的用户名
        String username = String.valueOf(info.getPrincipals());
        // 数据库中的密码
        String dbPassword = (String) info.getCredentials();
        User user = userService.queryUserByUserName(username);
        String salt = user.getSalt();
        return this.equals(StringUtil.md5(inPassword + salt), dbPassword);
    }
}

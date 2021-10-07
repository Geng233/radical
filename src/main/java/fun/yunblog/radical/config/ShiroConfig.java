package fun.yunblog.radical.config;

import fun.yunblog.radical.realm.MyRealm;
import fun.yunblog.radical.shiro.JwtFilter;
import fun.yunblog.radical.shiro.MyCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 耿子云
 * @date 2021/9/27
 * @Description add DefaultWebSecurityManager ShiroFilterFactoryBean JwtFilter AuthorizationAttributeSourceAdvisor
 * * DefaultWebSecurityManager DefaultWebSecurityManager需要MyRealm实体 而MyRealm实体需要MyCredentialsMatcher实体
 * * ShiroFilterFactoryBean ShiroFilterFactoryBean产生并配置的 可以配置过滤规则
 * * JwtFilter 自定义的 fun.yunblog.radical.shiro.JwtFilter
 * * AuthorizationAttributeSourceAdvisor 开启注解代理 例如@RequiresPermissions("permissionCode1")
 */
@Configuration
public class ShiroConfig {

    @Autowired
    private MyRealm myRealm;
    @Autowired
    private MyCredentialsMatcher myCredentialsMatcher;

    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager() {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        myRealm.setCredentialsMatcher(myCredentialsMatcher);
        manager.setRealm(myRealm);
        return manager;
    }

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager manager, JwtFilter jwtFilter) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(manager);
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("jwt", jwtFilter);
        shiroFilterFactoryBean.setFilters(filterMap);
        Map<String, String> map = new LinkedHashMap<>();
        // 由于使用链式，所以过滤规则自上而下
        map.put("/swagger-ui.html**", "anon");
        map.put("/v2/api-docs", "anon");
        map.put("/swagger-resources/**", "anon");
//        map.put("/css/**", "anon");
//        map.put("/js/**", "anon");
//        map.put("/index.html", "anon");
//        map.put("/fonts/**", "anon");
//        map.put("/favicon", "anon");
        map.put("/**", "jwt");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        shiroFilterFactoryBean.setLoginUrl("/user/login ");
        return shiroFilterFactoryBean;
    }

    // 开启注解代理
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public JwtFilter getJwtFiler() {
        return new JwtFilter();
    }
}

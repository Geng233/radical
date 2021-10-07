package fun.yunblog.radical.service;

import fun.yunblog.radical.model.domain.Role;

import java.util.Set;

/**
 * @author 耿子云
 * @date 2021/9/28
 */
public interface RoleService {
    Set<Role> queryRolesByUserName(String userName);
    Set<String> queryRolesNameByUserName(String userName);
}


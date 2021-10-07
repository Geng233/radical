package fun.yunblog.radical.service.impl;

import fun.yunblog.radical.model.domain.Role;
import fun.yunblog.radical.mapper.RoleMapper;
import fun.yunblog.radical.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author 耿子云
 * @date 2021/9/28
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Set<Role> queryRolesByUserName(String userName) {
        return roleMapper.selectRolesByUserName(userName);
    }

    @Override
    public Set<String> queryRolesNameByUserName(String userName) {
        return roleMapper.selectRolesNameByUserName(userName);
    }
}

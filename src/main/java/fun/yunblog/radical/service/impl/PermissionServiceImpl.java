package fun.yunblog.radical.service.impl;

import fun.yunblog.radical.model.domain.Permission;
import fun.yunblog.radical.mapper.PermissionMapper;
import fun.yunblog.radical.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author 耿子云
 * @date 2021/9/28
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public Set<Permission> queryPermissionByUserName(String userName) {
        return permissionMapper.selectPermissionByUserName(userName);
    }

    @Override
    public Set<String> queryPermissionCodeByUserName(String userName) {
        return permissionMapper.selectPermissionCodeByUserName(userName);
    }

    @Override
    public List<Permission> queryAllPermission() {
        return permissionMapper.selectAllPermission();
    }

    @Override
    public List<Permission> queryFatherPermissionByUserName(String userName) {
        return permissionMapper.selectFatherPermissionByUserName(userName);
    }

    @Override
    public List<Permission> querySubPermissionByFatherPermissionId(Long fatherPermissionId) {
        return permissionMapper.selectSubPermissionByFatherPermissionId(fatherPermissionId);
    }
}

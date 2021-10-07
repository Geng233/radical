package fun.yunblog.radical.service;

import fun.yunblog.radical.model.domain.Permission;
import fun.yunblog.radical.util.StringUtil;

import java.util.List;
import java.util.Set;

/**
 * @author 耿子云
 * @date 2021/9/28
 */
public interface PermissionService {

    Set<Permission> queryPermissionByUserName(String userName);

    Set<String> queryPermissionCodeByUserName(String userName);

    List<Permission> queryAllPermission();

    List<Permission> queryFatherPermissionByUserName(String userName);

    List<Permission> querySubPermissionByFatherPermissionId(Long fatherPermissionId);
}

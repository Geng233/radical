package fun.yunblog.radical.mapper;

import fun.yunblog.radical.model.domain.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

/**
 * @author 耿子云
 * @date 2021/9/28
 */
@Mapper
public interface PermissionMapper {

    // jwt需要
    @Select("SELECT permissionId,permissionName,permissionCode,permissionPath,permissionFatherId,permissionIsMenu FROM `user` NATURAL JOIN user_permission NATURAL JOIN `permission` WHERE userName = #{userName}")
    Set<Permission> selectPermissionByUserName(String userName);

    // jwt需要
    @Select("SELECT permissionCode FROM `user` NATURAL JOIN user_permission NATURAL JOIN `permission` WHERE userName = #{userName}")
    Set<String> selectPermissionCodeByUserName(String userName);

    @Select("select * from permission")
    List<Permission> selectAllPermission();

    @Select("select  permissionId,permissionName,permissionCode,permissionPath,permissionFatherId,permissionIsMenu from `user` NATURAL JOIN user_permission NATURAL JOIN `permission` WHERE userName = #{userName} " +
            "and permissionFatherId = 0 and permissionIsMenu = 1")
    List<Permission> selectFatherPermissionByUserName(String userName);

    @Select("select  permissionId,permissionName,permissionCode,permissionPath,permissionFatherId,permissionIsMenu from `permission` WHERE " +
            "permissionFatherId = #{fatherPermissionId} and permissionIsMenu = 1")
    List<Permission> selectSubPermissionByFatherPermissionId(Long fatherPermissionId);

}

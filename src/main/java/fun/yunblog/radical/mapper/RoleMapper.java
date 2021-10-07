package fun.yunblog.radical.mapper;

import fun.yunblog.radical.model.domain.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * @author 耿子云
 * @date 2021/9/28
 */
@Mapper
public interface RoleMapper {

    @Select("SELECT roleName,roleId FROM `user` NATURAL JOIN user_role NATURAL JOIN `role` WHERE userName = #{userName}")
    Set<Role> selectRolesByUserName(String userName);

    @Select("SELECT roleName FROM `user` NATURAL JOIN user_role NATURAL JOIN `role` WHERE userName = #{userName}")
    Set<String> selectRolesNameByUserName(String userName);
}

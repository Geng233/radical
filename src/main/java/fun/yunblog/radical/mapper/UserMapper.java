package fun.yunblog.radical.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import fun.yunblog.radical.model.domain.User;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

/**
 * @author 耿子云
 * @date 2021/9/26
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where userId = #{userId}")
    User selectUserByUserId(Long userId);

    @Select("Select * from user where userName = #{userName}")
    User selectUserByUserName(String userName);

    @Select("select * from user")
    List<User> selectAllUser();

    @Select("select `userId` from user where userName = #{userName}")
    Long selectUserIdByUserName(String userName);

    @Update("UPDATE `user` SET `password` = #{password} where userName = #{userName}")
    boolean updatePasswordByUserName(String password, String userName);

    @Update("UPDATE `user` SET `userName` = #{userName}, `password` = #{password}, `salt` = #{salt}," +
            " `userAvatar` = #{userAvatar}, `userEmail` = #{userEmail}, `userDescription` = #{userDescription}," +
            " `userLoginLast` = #{userLoginLast} where userId = #{userId}")
    boolean updateUser(Long userId,String userName, String password, String salt, String userAvatar, String userEmail, String userDescription, Date userLoginLast);
}

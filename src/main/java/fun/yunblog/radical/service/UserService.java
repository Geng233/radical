package fun.yunblog.radical.service;

import fun.yunblog.radical.model.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author 耿子云
 * @date 2021/9/27
 */
public interface UserService {

    User queryUserByUserId(Long userId);

    User queryUserByUserName(String userName);

    List<User> queryAllUser();

    List<Map<String, Object>> queryMenu(String userName);

    boolean alterPassWordByUserName(String oldPassword, String newPassword, String userName);

    boolean alterUserInfo(User user);
}

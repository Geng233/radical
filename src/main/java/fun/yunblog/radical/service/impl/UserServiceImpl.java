package fun.yunblog.radical.service.impl;

import fun.yunblog.radical.mapper.PermissionMapper;
import fun.yunblog.radical.model.domain.Permission;
import fun.yunblog.radical.model.domain.User;
import fun.yunblog.radical.mapper.UserMapper;
import fun.yunblog.radical.service.UserService;
import fun.yunblog.radical.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author 耿子云
 * @date 2021/9/27
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public User queryUserByUserId(Long userId) {
        return userMapper.selectUserByUserId(userId);
    }

    @Override
    public User queryUserByUserName(String userName) {
        return userMapper.selectUserByUserName(userName);
    }

    @Override
    public List<User> queryAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public List<Map<String, Object>> queryMenu(String userName) {
        List<Map<String, Object>> list = new ArrayList<>();
        List<Permission> fatherPermissions = permissionMapper.selectFatherPermissionByUserName(userName);
        for (Permission fatherPermission : fatherPermissions) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("fatherMenu", fatherPermission);
            List<Permission> subPermissions = permissionMapper.selectSubPermissionByFatherPermissionId(fatherPermission.getPermissionId());
            if (subPermissions.size() != 0) {
                map.put("subMenu", subPermissions);
            }
            list.add(map);
        }
        return list;
    }

    @Override
    public boolean alterPassWordByUserName(String oldPassword,String newPassword, String userName) {
        User user = userMapper.selectUserByUserName(userName);
        if (user != null) {
            String salt = user.getSalt();
            String password1 = StringUtil.md5(newPassword + salt);
            String password2 = StringUtil.md5(oldPassword + salt);
            System.out.println(user.getPassword());
            if (Objects.equals(password2, user.getPassword())) {
                return userMapper.updatePasswordByUserName(password1, userName);
            }
        }
        return false;
    }

    @Override
    public boolean alterUserInfo(User user) {
        User userGet = this.queryUserByUserId(user.getUserId());
        // 对表单不提交的敏感信息覆盖
        user.setPassword(userGet.getPassword());
        user.setSalt(userGet.getSalt());
        user.setUserLoginLast(userGet.getUserLoginLast());
        return userMapper.updateUser(user.getUserId(),user.getUserName(), user.getPassword(), user.getSalt(), user.getUserAvatar(), user.getUserEmail(), user.getUserDescription(), user.getUserLoginLast());
    }
}

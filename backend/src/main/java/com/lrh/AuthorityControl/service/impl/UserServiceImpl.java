package com.lrh.AuthorityControl.service.impl;

import com.lrh.AuthorityControl.common.AuthorityControlUtils;
import com.lrh.AuthorityControl.entity.User;
import com.lrh.AuthorityControl.entity.UserExample;
import com.lrh.AuthorityControl.mapper.UserMapper;
import com.lrh.AuthorityControl.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


/**
 * @author lrh
 * @version 1.0
 * @date 2020/2/6 17:56
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public User login(String loginAcct, String userPswd) {

        // 根据loginAcct查询数据库
        UserExample userExample = new UserExample();

        userExample.createCriteria().andLoginAcctEqualTo(loginAcct);

        // 执行查询
        List<User> list = userMapper.selectByExample(userExample);

        if(!AuthorityControlUtils.collectionEffective(list)) {

            // 如果查询结果集合无效，则直接返回null
            return null;
        }

        // 获取唯一集合元素
        User user = list.get(0);

        // 确认user不为null
        if(user == null) {
            return null;
        }

        // 比较密码
        String userPswdDataBase = user.getUserPswd();

        String userPswdBroswer = AuthorityControlUtils.md5(userPswd);

        if(Objects.equals(userPswdBroswer, userPswdDataBase)) {

            // 如果两个密码相等那么说明登录能够成功，返回User对象
            return user;
        }
        return  null;
    }
}

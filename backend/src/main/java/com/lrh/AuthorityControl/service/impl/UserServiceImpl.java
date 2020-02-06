package com.lrh.AuthorityControl.service.impl;

import com.lrh.AuthorityControl.entity.User;
import com.lrh.AuthorityControl.entity.UserExample;
import com.lrh.AuthorityControl.mapper.UserMapper;
import com.lrh.AuthorityControl.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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
}

package com.lrh.AuthorityControl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lrh.AuthorityControl.common.AuthorityControlUtils;
import com.lrh.AuthorityControl.entity.User;
import com.lrh.AuthorityControl.entity.UserExample;
import com.lrh.AuthorityControl.mapper.UserMapper;
import com.lrh.AuthorityControl.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

        if (!AuthorityControlUtils.collectionEffective(list)) {

            // 如果查询结果集合无效，则直接返回null
            return null;
        }

        // 获取唯一集合元素
        User user = list.get(0);

        // 确认user不为null
        if (user == null) {
            return null;
        }

        // 比较密码
        String userPswdDataBase = user.getUserPswd();

        String userPswdBroswer = AuthorityControlUtils.md5(userPswd);

        if (Objects.equals(userPswdBroswer, userPswdDataBase)) {

            // 如果两个密码相等那么说明登录能够成功，返回User对象
            return user;
        }
        return null;
    }

    @Override
    public PageInfo<User> queryForKeywordSearch(Integer pageNum, Integer pageSize, String keyword) {
        // 1.调用PageHelper的工具方法，开启分页功能
        PageHelper.startPage(pageNum, pageSize);

        // 2.执行分页查询
        List<User> list = userMapper.selectUserListByKeyword(keyword);

        // 3.将list封装到PageInfo对象中
        return new PageInfo<>(list);

    }

    @Override
    public void batchRemove(List<Integer> userIdList) {
        // QBC：Query By Criteria

        // 创建UserExample对象（不要管Example单词是什么意思，它没有意思）
        UserExample userExample = new UserExample();

        // 创建Criteria对象（不要管Criteria单词是什么意思，它没有意思）
        // Criteria对象可以帮助我们封装查询条件
        // 通过使用Criteria对象，可以把Java代码转换成SQL语句中WHERE子句里面的具体查询条件
        UserExample.Criteria criteria = userExample.createCriteria();

        // 针对要查询的字段封装具体的查询条件
        criteria.andTIdIn(userIdList);

        // 执行具体操作时把封装了查询条件的Example对象传入
        userMapper.deleteByExample(userExample);
    }

    @Override
    public void saveUser(User user) {
        // 对密码进行加密
        String userPswd = user.getUserPswd();
       userPswd = AuthorityControlUtils.md5(userPswd);
        user.setUserPswd(userPswd);

        // 执行保存
        userMapper.insert(user);
    }

    @Override
    public User getUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public void updateUser(User user) {
        // 对密码进行加密
        String userPswd = user.getUserPswd();
        userPswd = AuthorityControlUtils.md5(userPswd);
        user.setUserPswd(userPswd);

        // 执行更新
        userMapper.updateByPrimaryKey(user);
    }
}

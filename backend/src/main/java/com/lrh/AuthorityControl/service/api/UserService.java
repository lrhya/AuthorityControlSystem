package com.lrh.AuthorityControl.service.api;


import com.github.pagehelper.PageInfo;
import com.lrh.AuthorityControl.entity.User;

import java.util.List;

/**
 * @author lrh
 * @version 1.0
 * @date 2020/2/6 17:48
 */

public interface UserService {
    //获取用户表全部信息
    List<User> getAll();

    //登录验证
    User login(String loginAcct, String userPswd);

    //分页显示
    PageInfo<User> queryForKeywordSearch(Integer pageNum, Integer pageSize, String keyword);

    //批量删除
    void batchRemove(List<Integer> adminIdList);

    void saveUser(User user);
}

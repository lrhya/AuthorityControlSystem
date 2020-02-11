package com.lrh.AuthorityControl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lrh.AuthorityControl.entity.Role;
import com.lrh.AuthorityControl.mapper.RoleMapper;
import com.lrh.AuthorityControl.service.api.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lrhya
 * @version 1.0
 * @date 2020/2/10 15:27
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public PageInfo<Role> queryForKeywordWithPage(Integer pageNum, Integer pageSize, String keyword) {
        // 1.开启分页功能
        PageHelper.startPage(pageNum, pageSize);

        // 2.执行查询
        List<Role> list = roleMapper.selectForKeywordSearch(keyword);

        // 3.封装为PageInfo对象
        return new PageInfo<>(list);

    }
}

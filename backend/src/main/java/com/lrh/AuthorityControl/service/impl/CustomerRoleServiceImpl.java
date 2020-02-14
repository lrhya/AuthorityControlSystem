package com.lrh.AuthorityControl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lrh.AuthorityControl.entity.CustomerRole;
import com.lrh.AuthorityControl.entity.CustomerRole;
import com.lrh.AuthorityControl.mapper.CustomerRoleMapper;
import com.lrh.AuthorityControl.service.api.CustomerRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lrhya
 * @version 1.0
 * @date 2020/2/14 16:21
 */
@Service
public class CustomerRoleServiceImpl implements CustomerRoleService {

    @Autowired
    private CustomerRoleMapper customerRoleMapper;
    @Override
    public PageInfo<CustomerRole> queryForKeywordSearch(Integer pageNum, Integer pageSize, String keyword) {
        // 1.调用PageHelper的工具方法，开启分页功能
        PageHelper.startPage(pageNum, pageSize);

        // 2.执行分页查询
        List<CustomerRole> list = customerRoleMapper.selectCustomerRoleListByKeyword(keyword);

        // 3.将list封装到PageInfo对象中
        return new PageInfo<>(list);
    }
}

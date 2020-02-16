package com.lrh.AuthorityControl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lrh.AuthorityControl.entity.CustomerExample;
import com.lrh.AuthorityControl.entity.CustomerRole;
import com.lrh.AuthorityControl.entity.CustomerRoleExample;
import com.lrh.AuthorityControl.entity.Role;
import com.lrh.AuthorityControl.mapper.CustomerRoleMapper;
import com.lrh.AuthorityControl.service.api.CustomerRoleService;
import com.lrh.Common.Utils;
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
    public List<CustomerRole> getAll() {
        return customerRoleMapper.selectByExample(new CustomerRoleExample());
    }

    @Override
    public PageInfo<CustomerRole> queryForKeywordSearch(Integer pageNum, Integer pageSize, String keyword) {
        // 1.调用PageHelper的工具方法，开启分页功能
        PageHelper.startPage(pageNum, pageSize);

        // 2.执行分页查询
        List<CustomerRole> list = customerRoleMapper.selectCustomerRoleListByKeyword(keyword);

        // 3.将list封装到PageInfo对象中
        return new PageInfo<>(list);
    }

    @Override
    public void batchRemove(List<Integer> customerRoleIdList) {

        // QBC：Query By Criteria

        // 创建CustomerExample对象（不要管Example单词是什么意思，它没有意思）
        CustomerRoleExample customerRoleExample = new CustomerRoleExample();

        // 创建Criteria对象（不要管Criteria单词是什么意思，它没有意思）
        // Criteria对象可以帮助我们封装查询条件
        // 通过使用Criteria对象，可以把Java代码转换成SQL语句中WHERE子句里面的具体查询条件
        CustomerRoleExample.Criteria criteria = customerRoleExample.createCriteria();

        // 针对要查询的字段封装具体的查询条件
        criteria.andTIdIn(customerRoleIdList);

        // 执行具体操作时把封装了查询条件的Example对象传入
        customerRoleMapper.deleteByExample(customerRoleExample);
    }

    @Override
    public void saveCustomerRole(CustomerRole customerRole) {
        customerRoleMapper.insert(customerRole);
    }

    @Override
    public CustomerRole getCustomerRoleById(Integer customerRoleId) {
        return customerRoleMapper.selectByPrimaryKey(customerRoleId);
    }

    @Override
    public void updateCustomerRole(CustomerRole customerRole) {
        // 执行更新
        customerRoleMapper.updateByPrimaryKey(customerRole);
    }

    @Override
    public List<CustomerRole> getAssignedCustomerRoleList(Integer customerId) {
        List<CustomerRole> customerRoleList = customerRoleMapper.selectAssignedRoleList(customerId);

        return customerRoleList;
    }

    @Override
    public List<CustomerRole> getUnAssignedCustomerRoleList(Integer customerId) {

        List<CustomerRole> customerRoleList = customerRoleMapper.selectUnAssignedRoleList(customerId);

        return customerRoleList;
    }

    @Override
    public void updateRelationship(Integer customerId, List<Integer> customerRoleIdList) {

        // 1.删除全部旧数据
        customerRoleMapper.deleteOldCustomerRelationship(customerId);

        // 2.保存全部新数据
        if(Utils.collectionEffective(customerRoleIdList)) {
            customerRoleMapper.insertNewCustomerRelationship(customerId, customerRoleIdList);
        }

    }
}

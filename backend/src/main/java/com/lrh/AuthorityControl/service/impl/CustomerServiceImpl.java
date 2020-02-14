package com.lrh.AuthorityControl.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lrh.AuthorityControl.entity.Customer;
import com.lrh.AuthorityControl.entity.CustomerExample;
import com.lrh.AuthorityControl.mapper.CustomerMapper;
import com.lrh.AuthorityControl.service.api.CustomerService;
import com.lrh.Common.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lrhya
 * @version 1.0
 * @date 2020/2/14 14:48
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public List<Customer> getAll() {
        return customerMapper.selectByExample(new CustomerExample());
    }



    @Override
    public PageInfo<Customer> queryForKeywordSearch(Integer pageNum, Integer pageSize, String keyword) {


        String orderBy = "id  ASC";//按照排序字段 顺序    “id   desc  ” 倒序
        PageHelper.startPage(pageNum,pageSize,orderBy);
        // 1.调用PageHelper的工具方法，开启分页功能
        PageHelper.startPage(pageNum, pageSize);

        // 2.执行分页查询
        List<Customer> list = customerMapper.selectCustomerListByKeyword(keyword);

        // 3.将list封装到PageInfo对象中
        return new PageInfo<>(list);
    }

    @Override
    public void batchRemove(List<Integer> customerIdList) {


        // QBC：Query By Criteria

        // 创建CustomerExample对象（不要管Example单词是什么意思，它没有意思）
        CustomerExample customerExample = new CustomerExample();

        // 创建Criteria对象（不要管Criteria单词是什么意思，它没有意思）
        // Criteria对象可以帮助我们封装查询条件
        // 通过使用Criteria对象，可以把Java代码转换成SQL语句中WHERE子句里面的具体查询条件
        CustomerExample.Criteria criteria = customerExample.createCriteria();

        // 针对要查询的字段封装具体的查询条件
        criteria.andIdIn(customerIdList);

        // 执行具体操作时把封装了查询条件的Example对象传入
        customerMapper.deleteByExample(customerExample);

    }


    @Override
    public void saveCustomer(Customer customer) {

        // 对密码进行加密
        String userPswd = customer.getUserPswd();
        userPswd = Utils.md5(userPswd);
        customer.setUserPswd(userPswd);

        // 执行保存
        customerMapper.insert(customer);

    }

    @Override
    public Customer getCustomerById(Integer customerId) {
        return customerMapper.selectByPrimaryKey(customerId);
    }


    @Override
    public void updateCustomer(Customer customer) {

        // 对密码进行加密
        String userPswd = customer.getUserPswd();
        userPswd = Utils.md5(userPswd);
        customer.setUserPswd(userPswd);

        // 执行更新
        customerMapper.updateByPrimaryKey(customer);
    }
    
}

package com.lrh.AuthorityControl.service.api;

import com.github.pagehelper.PageInfo;
import com.lrh.AuthorityControl.entity.Customer;

import java.util.List;

/**
 * @author lrhya
 * @version 1.0
 * @date 2020/2/14 14:47
 */
public interface CustomerService {

    List<Customer> getAll();


    //分页显示信息
    PageInfo<Customer> queryForKeywordSearch(Integer pageNum, Integer pageSize, String keyword);

    //批量删除
    void batchRemove(List<Integer> customerIdList);

    void saveCustomer(Customer customer);

    Customer getCustomerById(Integer customerId);

    void updateCustomer(Customer customer);
}

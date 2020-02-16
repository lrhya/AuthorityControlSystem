package com.lrh.AuthorityControl.service.api;

import com.github.pagehelper.PageInfo;
import com.lrh.AuthorityControl.entity.CustomerRole;

import java.util.List;

/**
 * @author lrhya
 * @version 1.0
 * @date 2020/2/14 16:21
 */
public interface CustomerRoleService {

    List<CustomerRole> getAll();

    //分页显示
    PageInfo<CustomerRole> queryForKeywordSearch(Integer pageNum, Integer pageSize, String keyword);

    //批量删除
    void batchRemove(List<Integer> customerRoleIdList);

    void saveCustomerRole(CustomerRole customerRole);

    CustomerRole getCustomerRoleById(Integer customerRoleId);

    void updateCustomerRole(CustomerRole customerRole);

    List<CustomerRole> getAssignedCustomerRoleList(Integer customerId);

    List<CustomerRole> getUnAssignedCustomerRoleList(Integer customerId);


    void updateRelationship(Integer customerId, List<Integer> customerRoleIdList);
}

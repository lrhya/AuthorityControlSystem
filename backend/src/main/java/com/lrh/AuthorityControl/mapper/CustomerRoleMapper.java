package com.lrh.AuthorityControl.mapper;

import com.lrh.AuthorityControl.entity.CustomerRole;
import com.lrh.AuthorityControl.entity.CustomerRoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerRoleMapper {
    long countByExample(CustomerRoleExample example);

    int deleteByExample(CustomerRoleExample example);

    int deleteByPrimaryKey(Integer tId);

    int insert(CustomerRole record);

    int insertSelective(CustomerRole record);

    List<CustomerRole> selectByExample(CustomerRoleExample example);

    CustomerRole selectByPrimaryKey(Integer tId);

    int updateByExampleSelective(@Param("record") CustomerRole record, @Param("example") CustomerRoleExample example);

    int updateByExample(@Param("record") CustomerRole record, @Param("example") CustomerRoleExample example);

    int updateByPrimaryKeySelective(CustomerRole record);

    int updateByPrimaryKey(CustomerRole record);

    List<CustomerRole> selectCustomerRoleListByKeyword(String keyword);

    List<CustomerRole> selectAssignedRoleList(Integer customerId);

    List<CustomerRole> selectUnAssignedRoleList(Integer customerId);

    void deleteOldCustomerRelationship(Integer customerId);

    void insertNewCustomerRelationship(@Param("customerId")Integer customerId, @Param("customerRoleIdList")List<Integer> customerRoleIdList);
}
package com.lrh.AuthorityControl.mapper;

import com.lrh.AuthorityControl.entity.Menu;
import com.lrh.AuthorityControl.entity.MenuExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper {
    long countByExample(MenuExample example);

    int deleteByExample(MenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuExample example);

    Menu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> selectAssignedMenuList(Integer customerRoleId);

    List<Menu> selectUnAssignedMenuList(Integer customerRoleId);


    void deleteOldMenuRelationship(Integer customerRoleId);
    void insertNewMenuRelationship(@Param("customerRoleId") Integer customerRoleId,@Param("customerMenuIdList")  List<Integer> customerMenuIdList);


}
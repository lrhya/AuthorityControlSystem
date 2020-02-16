package com.lrh.AuthorityControl.service.api;


import com.lrh.AuthorityControl.entity.Menu;

import java.util.List;

/**
 * @author lrhya
 * @version 1.0
 * @date 2020/1/31 13:22
 */
public interface MenuService {


    List<Menu> getAll();

    void saveMenu(Menu menu);

    Menu getMenuById(Integer menuId);

    void updateMenu(Menu menu);

    void removeMenu(Integer menuId);

    List<Menu> getAssignedCustomerMenuList(Integer customerRoleId) ;


    List<Menu> getUnAssignedCustomerMenuList(Integer customerRoleId) ;

    void updateRelationship(Integer customerRoleId, List<Integer> customerMenuIdList);
}

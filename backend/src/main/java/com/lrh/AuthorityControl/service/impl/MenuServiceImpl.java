package com.lrh.AuthorityControl.service.impl;


import com.lrh.AuthorityControl.entity.Menu;
import com.lrh.AuthorityControl.entity.MenuExample;
import com.lrh.AuthorityControl.entity.Role;
import com.lrh.AuthorityControl.mapper.MenuMapper;
import com.lrh.AuthorityControl.service.api.MenuService;
import com.lrh.Common.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lrhya
 * @version 1.0
 * @date 2020/1/31 13:25
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getAll() {
        return menuMapper.selectByExample(new MenuExample());
    }

    @Override
    public void saveMenu(Menu menu) {
        menuMapper.insert(menu);
    }

    @Override
    public Menu getMenuById(Integer menuId) {
        return menuMapper.selectByPrimaryKey(menuId);
    }

    @Override
    public void updateMenu(Menu menu) {
        menuMapper.updateByPrimaryKey(menu);
    }

    @Override
    public void removeMenu(Integer menuId) {
        menuMapper.deleteByPrimaryKey(menuId);
    }

    @Override
    public List<Menu> getAssignedCustomerMenuList(Integer customerRoleId) {
        List<Menu> menuList = menuMapper.selectAssignedMenuList(customerRoleId);

        return menuList;
    }

    @Override
    public List<Menu> getUnAssignedCustomerMenuList(Integer customerRoleId) {
        List<Menu> menuList = menuMapper.selectUnAssignedMenuList(customerRoleId);

        return menuList;
    }

    @Override
    public void updateRelationship(Integer customerRoleId, List<Integer> customerMenuIdList) {
        // 1.删除全部旧数据
        menuMapper.deleteOldMenuRelationship(customerRoleId);

        // 2.保存全部新数据
        if(Utils.collectionEffective(customerMenuIdList)) {
            menuMapper.insertNewMenuRelationship(customerRoleId, customerMenuIdList);
        }
    }
}

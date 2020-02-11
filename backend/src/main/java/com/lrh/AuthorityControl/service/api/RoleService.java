package com.lrh.AuthorityControl.service.api;


import com.github.pagehelper.PageInfo;
import com.lrh.AuthorityControl.entity.Role;

import java.util.List;

/**
 * @author lrhya
 * @version 1.0
 * @date 2020/2/10 15:26
 */
public interface RoleService {


    void updateRole(Role role);

    void saveRole(String roleName);

    void batchRemove(List<Integer> roleIdList);

    List<Role> getRoleListByIdList(List<Integer> roleIdList);

    PageInfo<Role> queryForKeywordWithPage(
            Integer pageNum,
            Integer pageSize,
            String keyword);

    List<Role> getAssignedRoleList(Integer adminId);

    List<Role> getUnAssignedRoleList(Integer adminId);

    void updateRelationship(Integer adminId, List<Integer> roleIdList);
}

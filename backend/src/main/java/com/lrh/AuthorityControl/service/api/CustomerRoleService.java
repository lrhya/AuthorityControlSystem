package com.lrh.AuthorityControl.service.api;

import com.github.pagehelper.PageInfo;
import com.lrh.AuthorityControl.entity.CustomerRole;

/**
 * @author lrhya
 * @version 1.0
 * @date 2020/2/14 16:21
 */
public interface CustomerRoleService {
    //分页显示
    PageInfo<CustomerRole> queryForKeywordSearch(Integer pageNum, Integer pageSize, String keyword);
}

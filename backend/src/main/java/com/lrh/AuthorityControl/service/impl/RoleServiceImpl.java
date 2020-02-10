package com.lrh.AuthorityControl.service.impl;

import com.lrh.AuthorityControl.mapper.RoleMapper;
import com.lrh.AuthorityControl.service.api.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lrhya
 * @version 1.0
 * @date 2020/2/10 15:27
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


}

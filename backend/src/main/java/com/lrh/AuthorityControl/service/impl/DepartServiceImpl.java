package com.lrh.AuthorityControl.service.impl;

import com.lrh.AuthorityControl.mapper.DepartMapper;
import com.lrh.AuthorityControl.service.api.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lrhya
 * @version 1.0
 * @date 2020/2/12 14:29
 */
@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    private DepartMapper departMapper;
}

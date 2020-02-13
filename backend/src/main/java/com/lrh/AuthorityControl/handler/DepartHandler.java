package com.lrh.AuthorityControl.handler;

import com.lrh.AuthorityControl.service.api.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lrhya
 * @version 1.0
 * @date 2020/2/12 14:28
 */
@RestController
public class DepartHandler {

    @Autowired
    private DepartService departService;
}

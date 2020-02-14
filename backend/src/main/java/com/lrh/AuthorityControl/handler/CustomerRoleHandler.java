package com.lrh.AuthorityControl.handler;

import com.github.pagehelper.PageInfo;
import com.lrh.AuthorityControl.entity.CustomerRole;
import com.lrh.AuthorityControl.service.api.CustomerRoleService;
import com.lrh.Common.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lrhya
 * @version 1.0
 * @date 2020/2/14 16:22
 */
@Controller
public class CustomerRoleHandler {

    @Autowired
    private CustomerRoleService customerRoleService;

    @RequestMapping("/customerRole/to/page")
    public String queryForSearch(
            // 如果页面上没有提供对应的请求参数，那么可以使用defaultValue指定默认值
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "keyword", defaultValue = "") String keyword,
            Model model) {

        PageInfo<CustomerRole> pageInfo = customerRoleService.queryForKeywordSearch(pageNum, pageSize, keyword);

        model.addAttribute(Constant.ATTR_NAME_PAGE_INFO, pageInfo);

        return "KnowledgeControl/customerRole/customerRole-page";
    }
}

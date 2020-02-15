package com.lrh.AuthorityControl.handler;

import com.github.pagehelper.PageInfo;
import com.lrh.AuthorityControl.entity.CustomerRole;
import com.lrh.AuthorityControl.entity.ResultEntity;
import com.lrh.AuthorityControl.service.api.CustomerRoleService;
import com.lrh.Common.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lrhya
 * @version 1.0
 * @date 2020/2/14 16:22
 */
@Controller
public class CustomerRoleHandler {

    @Autowired
    private CustomerRoleService customerRoleService;


    @RequestMapping("/customerRole/update")
    public String updateCustomerRole(CustomerRole customerRole) {

        try {
            customerRoleService.updateCustomerRole(customerRole);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof DuplicateKeyException) {
                throw new RuntimeException(Constant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
            }
        }
        return "redirect:/customerRole/to/page";
    }


    @RequestMapping("/customerRole/to/edit/page")
    public String toEditPage(@RequestParam("customerRoleId") Integer customerRoleId, Model model) {

        CustomerRole customerRole = customerRoleService.getCustomerRoleById(customerRoleId);

        model.addAttribute("customerRole", customerRole);

        return "KnowledgeControl/customerRole/customerRole-edit";
    }



    @RequestMapping("/customerRole/save")
    public String saveCustomerRole(CustomerRole customerRole) {
        try {
            customerRoleService.saveCustomerRole(customerRole);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof DuplicateKeyException) {
                throw new RuntimeException(Constant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
            }
        }
        //return "redirect:/customerRole/query/for/search.html";
        // 操作完成后立即看到新增的记录,跳转到分页页面时前往最后一页
        return "redirect:/customerRole/to/page?pageNum="+Integer.MAX_VALUE;
    }



    // handler方法
// 将当前handler方法的返回值作为响应体返回，不经过视图解析器
    @ResponseBody
    @RequestMapping("/customerRole/batch/remove")
    public ResultEntity<String> batchRemove(@RequestBody List<Integer> customerRoleIdList) {
        try {
            customerRoleService.batchRemove(customerRoleIdList);
            return ResultEntity.successWithoutData();
        }catch(Exception e) {
            return ResultEntity.failed(null, e.getMessage());
        }
    }

    
    @RequestMapping("/customerRole/to/page")
    public String queryForSearch(
            // 如果页面上没有提供对应的请求参数，那么可以使用defaultValue指定默认值
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
            @RequestParam(value = "keyword", defaultValue = "") String keyword,
            Model model) {

        PageInfo<CustomerRole> pageInfo = customerRoleService.queryForKeywordSearch(pageNum, pageSize, keyword);

        model.addAttribute(Constant.ATTR_NAME_PAGE_INFO, pageInfo);

        return "KnowledgeControl/customerRole/customerRole-page";
    }
}

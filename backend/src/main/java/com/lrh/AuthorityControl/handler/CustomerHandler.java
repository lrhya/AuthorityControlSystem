package com.lrh.AuthorityControl.handler;

import com.github.pagehelper.PageInfo;
import com.lrh.AuthorityControl.entity.ResultEntity;
import com.lrh.AuthorityControl.entity.Customer;
import com.lrh.AuthorityControl.service.api.CustomerService;
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
 * @date 2019/12/27 16:14
 */
@Controller
public class CustomerHandler {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customer/update")
    public String updateCustomer(Customer customer) {

        try {
            customerService.updateCustomer(customer);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof DuplicateKeyException) {
                throw new RuntimeException(Constant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
            }
        }
        return "redirect:/customer/query/for/search";
    }


    @RequestMapping("/customer/to/edit/page")
    public String toEditPage(@RequestParam("customerId") Integer customerId, Model model) {

        Customer customer = customerService.getCustomerById(customerId);

        model.addAttribute("customer", customer);

        return "KnowledgeControl/customer/customer-edit";
    }



    @RequestMapping("/customer/save")
    public String saveCustomer(Customer customer) {
        try {
            customerService.saveCustomer(customer);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof DuplicateKeyException) {
                throw new RuntimeException(Constant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
            }
        }
        //return "redirect:/customer/query/for/search.html";
        // 操作完成后立即看到新增的记录,跳转到分页页面时前往最后一页
        return "redirect:/customer/query/for/search?pageNum="+Integer.MAX_VALUE;
    }



    // handler方法
// 将当前handler方法的返回值作为响应体返回，不经过视图解析器
    @ResponseBody
    @RequestMapping("/customer/batch/remove")
    public ResultEntity<String> batchRemove(@RequestBody List<Integer> customerIdList) {
        try {
            customerService.batchRemove(customerIdList);
            return ResultEntity.successWithoutData();
        }catch(Exception e) {
            return ResultEntity.failed(null, e.getMessage());
        }
    }





    @RequestMapping("/customer/query/for/search")
    public String queryForSearch(
            // 如果页面上没有提供对应的请求参数，那么可以使用defaultValue指定默认值
            @RequestParam(value="pageNum", defaultValue="1") Integer pageNum,
            @RequestParam(value="pageSize", defaultValue="2") Integer pageSize,
            @RequestParam(value="keyword", defaultValue="") String keyword,
            Model model) {

        PageInfo<Customer> pageInfo = customerService.queryForKeywordSearch(pageNum, pageSize, keyword);

        model.addAttribute(Constant.ATTR_NAME_PAGE_INFO, pageInfo);

        return "KnowledgeControl/customer/customer-page";
    }

}

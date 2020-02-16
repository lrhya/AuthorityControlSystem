package com.lrh.AuthorityControl.handler;

import com.lrh.AuthorityControl.entity.CustomerRole;
import com.lrh.AuthorityControl.entity.Menu;
import com.lrh.AuthorityControl.service.api.CustomerRoleService;
import com.lrh.AuthorityControl.service.api.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author lrhya
 * @version 1.0
 * @date 2020/2/15 15:49
 */
@Controller
public class CustomerAssignHandler {

    @Autowired
    private CustomerRoleService customerRoleService;


    @Autowired
    private MenuService menuService;


    @RequestMapping("/customerRoleAssign/menu")
    public String doCustomerAssignMenu(
            // roleIdList不一定每一次都能够提供，没有提供我们也接受
            @RequestParam(value="customerMenuIdList", required=false) List<Integer> customerMenuIdList,
            @RequestParam("customerRoleId") Integer customerRoleId,
            @RequestParam("pageNum") String pageNum) {

        menuService.updateRelationship(customerRoleId, customerMenuIdList);

        return "redirect:/customerRole/to/page?pageNum=" + pageNum;
    }




    @RequestMapping("/assign/to/customerAssign/menu/page")
    public String toAssignCustomerMenuPage(@RequestParam("customerRoleId") Integer customerRoleId, Model model) {

        // 1.查询已分配角色
        List<Menu> assignedCustomerMenuList = menuService.getAssignedCustomerMenuList(customerRoleId);

        // 2.查询未分配角色
        List<Menu> unAssignedCustomerMenuList = menuService.getUnAssignedCustomerMenuList(customerRoleId);

        // 3.存入模型
        model.addAttribute("assignedCustomerMenuList", assignedCustomerMenuList);
        model.addAttribute("unAssignedCustomerMenuList", unAssignedCustomerMenuList);

        return "KnowledgeControl/customerRole/assign-customerMenu";
    }



    @RequestMapping("/customerAssign/role")
    public String doCustomerAssignRole(
            // roleIdList不一定每一次都能够提供，没有提供我们也接受
            @RequestParam(value="customerRoleIdList", required=false) List<Integer> customerRoleIdList,
            @RequestParam("customerId") Integer customerId,
            @RequestParam("pageNum") String pageNum) {

        customerRoleService.updateRelationship(customerId, customerRoleIdList);

        return "redirect:/customer/query/for/search?pageNum=" + pageNum;
    }




    
    @RequestMapping("/assign/to/customerAssign/role/page")
    public String toAssignCustomerRolePage(@RequestParam("customerId") Integer customerId, Model model) {

        // 1.查询已分配角色
        List<CustomerRole> assignedCustomerRoleList = customerRoleService.getAssignedCustomerRoleList(customerId);

        // 2.查询未分配角色
        List<CustomerRole> unAssignedCustomerRoleList = customerRoleService.getUnAssignedCustomerRoleList(customerId);

        // 3.存入模型
        model.addAttribute("assignedCustomerRoleList", assignedCustomerRoleList);
        model.addAttribute("unAssignedCustomerRoleList", unAssignedCustomerRoleList);

        return "KnowledgeControl/customer/assign-customerRole";
    }

}

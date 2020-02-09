package com.lrh.AuthorityControl.handler;

import com.github.pagehelper.PageInfo;
import com.lrh.AuthorityControl.common.AuthorityControlConstant;
import com.lrh.AuthorityControl.entity.ResultEntity;
import com.lrh.AuthorityControl.entity.User;
import com.lrh.AuthorityControl.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author lrhya
 * @version 1.0
 * @date 2020/2/7 13:45
 */
@Controller
public class UserHandler {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/to/update")
    public String updateUser(User user) {

        try {
            userService.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof DuplicateKeyException) {
                throw new RuntimeException(AuthorityControlConstant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
            }
        }
        return "redirect:/user/to/page";
    }



    @RequestMapping("/user/to/edit")
    public String toEditPage(@RequestParam("userId") Integer userId, Model model) {

        User user = userService.getUserById(userId);

        model.addAttribute("user", user);

        return "user/user-edit";
    }


    @RequestMapping("/user/to/save")
    public String saveUser(User User) {
        try {
            userService.saveUser(User);
        } catch (Exception e) {
            e.printStackTrace();
            if(e instanceof DuplicateKeyException) {
                throw new RuntimeException(AuthorityControlConstant.MESSAGE_LOGIN_ACCT_ALREADY_IN_USE);
            }
        }
        //return "redirect:/user/to/page";
        // 操作完成后立即看到新增的记录,跳转到分页页面时前往最后一页
        return "redirect:/user/to/page?pageNum="+Integer.MAX_VALUE;
    }



    // handler方法
// 将当前handler方法的返回值作为响应体返回，不经过视图解析器
    @ResponseBody
    @RequestMapping("/user/batch/remove")
    public ResultEntity<String> batchRemove(@RequestBody List<Integer> UserIdList) {
        try {
            userService.batchRemove(UserIdList);
            return ResultEntity.successWithoutData();
        }catch(Exception e) {
            return ResultEntity.failed(null, e.getMessage());
        }
    }


    @RequestMapping("/user/to/page")
    public String queryForSearch(
            // 如果页面上没有提供对应的请求参数，那么可以使用defaultValue指定默认值
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "keyword", defaultValue = "") String keyword,
            Model model) {

        PageInfo<User> pageInfo = userService.queryForKeywordSearch(pageNum, pageSize, keyword);

        model.addAttribute(AuthorityControlConstant.ATTR_NAME_PAGE_INFO, pageInfo);

        return "user/user-page";
    }


    @RequestMapping("user/do/login")
    public String doLogin(@RequestParam("loginAcct") String loginAcct,
                          @RequestParam("userPswd") String userPswd,
                          HttpSession session) {
        // 调用userService的login方法执行登录业务逻辑，返回查询到的User对象
        User user = userService.login(loginAcct, userPswd);

        //判断user是否为null
        if (user == null) {
            session.setAttribute(AuthorityControlConstant.ATTR_NAME_MESSAGE, AuthorityControlConstant.MESSAGE_LOGIN_FAILED);
            return "redirect:/index.html";
        }
        session.setAttribute(AuthorityControlConstant.ATTR_NAME_LOGIN_ADMIN, user);
        return "redirect:/main/to/page";
    }


    @RequestMapping("/user/get/all")
    public String getAll(Model model) {
        List<User> list = userService.getAll();
        model.addAttribute("list", list);
        return "test/test-target";    //  "/WEB-INF/pages/test/test-target"
    }
}

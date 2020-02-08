package com.lrh.AuthorityControl.handler;

import com.lrh.AuthorityControl.common.AuthorityControlConstant;
import com.lrh.AuthorityControl.entity.User;
import com.lrh.AuthorityControl.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "redirect:/user/to/main/page";
    }

    @RequestMapping("/user/get/all")
    public String getAll(Model model) {
        List<User> list = userService.getAll();
        model.addAttribute("list", list);
        return "test/test-target";    //  "/WEB-INF/pages/test/test-target"
    }
}

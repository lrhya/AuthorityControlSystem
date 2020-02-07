package com.lrh.AuthorityControl.handler;

        import com.lrh.AuthorityControl.entity.User;
        import com.lrh.AuthorityControl.service.api.UserService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/user/get/all")
    public String getAll(Model model) {
        List<User> list = userService.getAll();
        model.addAttribute("list", list);
        return "test/test-target";    //  "/WEB-INF/pages/test/test-target"
    }
}

package com.lrh.AuthorityControl.handler;

import com.github.pagehelper.PageInfo;
import com.lrh.AuthorityControl.entity.ResultEntity;
import com.lrh.AuthorityControl.entity.Role;
import com.lrh.AuthorityControl.service.api.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lrhya
 * @version 1.0
 * @date 2020/2/10 15:29
 */
@Controller
public class RoleHandler {
    @Autowired
    private RoleService roleService;


    @ResponseBody
    @RequestMapping("/role/to/page")
    public ResultEntity<PageInfo<Role>> search(
            @RequestParam(value="pageNum", defaultValue="1") Integer pageNum,
            @RequestParam(value="pageSize", defaultValue="5") Integer pageSize,
            @RequestParam(value="keyword", defaultValue="") String keyword
    ) {

        // 1.查询得到PageInfo对象
        PageInfo<Role> pageInfo = roleService.queryForKeywordWithPage(pageNum, pageSize, keyword);

        // 2.封装结果对象返回
        return ResultEntity.successWithData(pageInfo);
    }



}

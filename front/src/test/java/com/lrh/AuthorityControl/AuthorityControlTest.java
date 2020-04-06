package com.lrh.AuthorityControl;

import com.lrh.AuthorityControl.entity.Customer;
import com.lrh.AuthorityControl.entity.User;
import com.lrh.AuthorityControl.mapper.CustomerMapper;
import com.lrh.AuthorityControl.mapper.UserMapper;
import com.lrh.AuthorityControl.service.api.CustomerService;
import com.lrh.AuthorityControl.service.api.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author lrh
 * @version 1.0
 * @date 2020/2/6 12:58
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml"})

public class AuthorityControlTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerService customerService;
    @Test
    public void testConnection() throws SQLException {
        Connection connection = dataSource.getConnection();

        System.out.println(connection);
    }


    @Test
    public void testMybatis() {
        List<User> userList = userService.getAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void batchSaveUser() {
        for(int i = 0; i < 500; i++) {
            userMapper.insert(new User(null, "loginAcct"+i, "1111111", "userName"+i, "useremail"+i+"@qq.com", "研发一中心","核心组",""));
        }
    }

    @Test
    public void batchSaveCustomer() {
        for(int i = 0; i < 500; i++) {
            customerMapper.insert(new Customer(null, "loginAcct"+i, "1111111", "userName"+i, "useremail"+i+"@qq.com", ""));
        }
    }


}

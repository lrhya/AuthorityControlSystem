package com.lrh.AuthorityControl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author lrhya
 * @version 1.0
 * @date 2020/4/6 14:13
 */
@Configuration
@EnableWebSecurity
//表示启用全局方法权限管理功能。
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class AuthorityControlSecurityConfig extends WebSecurityConfigurerAdapter {
}

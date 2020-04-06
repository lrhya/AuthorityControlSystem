package com.lrh.AuthorityControl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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


    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {

        //	测试使用
		builder
			.inMemoryAuthentication()
			.withUser("xixi")
			.password("12323")
			.roles("king");
      /*  builder.userDetailsService(userDetailsService);
    /*    builder.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());*/
    }
    @Override
    protected void configure(HttpSecurity security) throws Exception {
        //放行首页、静态资源。
        security.authorizeRequests()
                .antMatchers("/index.html","/statics/bootstrap/**","/statics/css/**","/fonts/**","/statics/images/**","/statics/jquery/**","/statics/layer/**","/statics/script/**","/  statics//ztree/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/index.html")
                .permitAll()
                .loginProcessingUrl("/user/do/login")
                .permitAll()
                .usernameParameter("loginAcct")
                .passwordParameter("userPswd")
                .defaultSuccessUrl("/main/to/page")
                .and()
                .csrf()
                .disable();




    }
}

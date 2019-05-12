package edu.snnu.startyun.configuration;

import edu.snnu.startyun.service.serviceImpl.TeacherUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    TeacherUserService teacherUserService() {
        return new TeacherUserService();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/web/**").hasRole("teacher");
        http.csrf().disable();
        http.formLogin()
                .usernameParameter("teacherId")
                .passwordParameter("password")
                .loginPage("/")
                .loginProcessingUrl("/web/login")
                //.successForwardUrl("/success")
                //.failureUrl("/login?error")
                .permitAll(); //登录页面用户任意访问

        http.logout().logoutSuccessUrl("/");

        //开启记住我功能
        http.rememberMe().rememberMeParameter("remember");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(teacherUserService());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**","/css/**","/img/**");
    }
}

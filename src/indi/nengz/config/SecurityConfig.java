package indi.nengz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;



@Configuration
@EnableWebSecurity
@ComponentScan
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource basicDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
//        auth.inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER").and()
//                .withUser("admin").password("password").roles("ADMIN");
        auth.jdbcAuthentication().dataSource(basicDataSource)
                .usersByUsernameQuery("select username,password,true from user where username=?")
                .authoritiesByUsernameQuery("select username,ROLE_USER from user where username=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.formLogin() //启动默认的登陆界面
                .and()
                .authorizeRequests()
                .antMatchers("/add").authenticated()             // add路径需要登陆认证
                .antMatchers("/search").hasAnyRole("ADMIN")  //只有admin权限才能登陆
                .anyRequest().permitAll()//其他的全部允许访问
                .and()
                .csrf().disable(); //禁用CSRF防御
//                .and()
//                .requiresChannel()
//                .antMatchers("/search").requiresSecure(); //需要https  需要SSL证书
    }
}

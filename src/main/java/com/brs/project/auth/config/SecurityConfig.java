package com.brs.project.auth.config;

import com.brs.project.auth.service.AuthServiceImpl;
import com.brs.project.auth.service.PasswordEnconderTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private SecurityFilter securityFilter;
    private AuthServiceImpl customUserDetailsService;

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PasswordEnconderTest();
    }

    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(getCustomUserDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS,
                 "/sl/userGroupMtn/**",
                "/sl/login/**",
                "/sl/user/doAddUserApi",
                "/sl/user/doCheckUserName",
                "/sl/user/doCheckUserEmail",
                "/sl/user/**",
                "/sl/passvlt/**",
                "/sl/category/**",
                "/sl/account/**",
                "/sl/transaction/**").permitAll()
                .antMatchers(HttpMethod.POST,
                "/sl/userGroupMtn/**",
                "/sl/login/**",
                "/sl/user/doAddUserApi",
                "/sl/user/doCheckUserName",
                "/sl/user/doCheckUserEmail",
                "/sl/category/**").permitAll()
                .antMatchers(
                "/sl/user/**",
                "/sl/passvlt/**",
                "/sl/account/**",
                "/sl/transaction/**")
                .hasAnyRole("ADM","UL1","UL2")
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        ;

        http.addFilterBefore(getSecurityFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Autowired
    public void setSecurityFilter(SecurityFilter securityFilter) {
        this.securityFilter = securityFilter;
    }

    public SecurityFilter getSecurityFilter() {
        return securityFilter;
    }

    public AuthServiceImpl getCustomUserDetailsService() {
        return customUserDetailsService;
    }

    @Autowired
    public void setCustomUserDetailsService(AuthServiceImpl customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }
}


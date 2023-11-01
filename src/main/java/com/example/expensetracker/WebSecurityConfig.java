//package com.example.expensetracker;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebSecurityConfig implements WebMvcConfigurer {
//
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/swagger-ui").setViewName("swagger-ui");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
//                .anyRequest().authenticated();
//    }
//
//
//}
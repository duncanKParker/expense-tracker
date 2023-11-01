package com.example.expensetracker.CORSFilter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class CustomConfiguration {

    @Bean
    public FilterRegistrationBean<AddedSimpleCORSFilter> simpleCORSFilter() {
        FilterRegistrationBean<AddedSimpleCORSFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AddedSimpleCORSFilter());
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return registrationBean;
    }

}

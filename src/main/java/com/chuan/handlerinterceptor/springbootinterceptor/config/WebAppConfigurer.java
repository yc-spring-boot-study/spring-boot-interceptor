package com.chuan.handlerinterceptor.springbootinterceptor.config;

import com.chuan.handlerinterceptor.springbootinterceptor.filter.TestFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestFilter()).addPathPatterns("/**");
    }
}

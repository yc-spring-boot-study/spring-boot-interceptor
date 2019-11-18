package com.chuan.handlerinterceptor.springbootinterceptor;

import com.chuan.handlerinterceptor.springbootinterceptor.filter.HttpServletRequestReplacedFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * SpringBoot通过JedisCluster连接Redis集群（分布式项目）--- 分布式锁
 * https://blog.csdn.net/zhibo_lv/article/details/81513516
 *
 * SpringBoot之HandlerInterceptor拦截器的使用 ——（四）防重复提交
 * https://blog.csdn.net/zhibo_lv/article/details/81905300
 */
@SpringBootApplication
public class SpringBootInterceptorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootInterceptorApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean httpServletRequestReplacedRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new HttpServletRequestReplacedFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("httpServletRequestReplacedFilter");
        registration.setOrder(1);
        return registration;
    }
}

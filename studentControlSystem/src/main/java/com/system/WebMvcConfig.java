package com.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

//    @Autowired
//    private MyInterceptor interceptor;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/user/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/health/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/admin/**").addResourceLocations("classpath:/static/");
       // registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        //registry.addResourceHandler("/image/**").addResourceLocations("file:E:/img/");
        super.addResourceHandlers(registry);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns("/").excludePathPatterns("/login");
        super.addInterceptors(registry);
    }
}

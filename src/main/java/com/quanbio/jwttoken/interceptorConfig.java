package com.quanbio.jwttoken;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class interceptorConfig implements WebMvcConfigurer
{
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTIntercept())
                .addPathPatterns("/**")   //拦截所有的路径
                .excludePathPatterns("/api/userlogin/**"); //放行login目录下的,因为生成token的方法拦截就无法生成token了
    }
}

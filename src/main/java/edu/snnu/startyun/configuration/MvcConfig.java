package edu.snnu.startyun.configuration;

import edu.snnu.startyun.compoment.LoginHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 *
 * 拦截器配置
 */
@Configuration
public class MvcConfig extends WebMvcConfigurationSupport {
    // 以下WebMvcConfigurerAdapter 比较常用的重写接口
    // /** 解决跨域问题 **/
    // public void addCorsMappings(CorsRegistry registry) ;
    // /** 添加拦截器 **/
    // void addInterceptors(InterceptorRegistry registry);
    // /** 这里配置视图解析器 **/
    // void configureViewResolvers(ViewResolverRegistry registry);
    // /** 配置内容裁决的一些选项 **/
    // void configureContentNegotiation(ContentNegotiationConfigurer
    // configurer);
    // /** 视图跳转控制器 **/
    // void addViewControllers(ViewControllerRegistry registry);
    // /** 静态资源处理 **/
    // void addResourceHandlers(ResourceHandlerRegistry registry);
    // /** 默认静态资源处理器 **/
    // void configureDefaultServletHandling(DefaultServletHandlerConfigurer
    // configurer);

    @Autowired
    private LoginHandlerInterceptor interceptor;


    /**
     * 表示这些配置的表示静态文件所处路径， 不用拦截
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/templates/");
        super.addResourceHandlers(registry);
    }

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor)
                // addPathPatterns 用于添加拦截规则 ， 先把所有路径都加入拦截， 再一个个排除
                .addPathPatterns("/**")
                // excludePathPatterns 表示改路径不用拦截
                .excludePathPatterns("/");
        super.addInterceptors(registry);
    }

    /*
    自定义简单页面跳转
     */
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/success").setViewName("success");
    }
}

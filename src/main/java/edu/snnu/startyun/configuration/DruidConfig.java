package edu.snnu.startyun.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    /*
    Druid数据源配置
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

    //配置druid监控
    //1.配置管理后台的servlet
    /*@Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        Map<String, String> map = new HashMap<>();
        map.put("loginUsername", "admin");
        map.put("loginPassword", "123456");
        //map.put("deny", "192.168.0.1");
        bean.setInitParameters(map);
        return bean;
    }

    //配置web监控的filter
    /*@Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());

        Map<String, String> map = new HashMap<>();
        map.put("exclusion", "*.js,*.css,/druid/*");

        bean.setInitParameters(map);
        bean.setUrlPatterns(Collections.singletonList("/*"));
        return bean;
    }*/
}

package cn.happyworlds.imgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextListener;

import cn.happyworlds.imgmt.aop.MyBatisPageHelperInterceptor;
import cn.happyworlds.imgmt.aop.WebHandleInterceptorAdvisor;
import cn.happyworlds.imgmt.spring.ApplicationContextHolder;
import cn.happyworlds.imgmt.spring.mvc.HandlerExceptionViewResolver;
import cn.happyworlds.imgmt.web.WebsiteListener;

/**
 * Created by jia on 2015/7/5.
 */
@SpringBootApplication
public class ImgmtApplication extends SpringBootServletInitializer {
//	测试
    public static void main(String[] args) {
        SpringApplication.run(ImgmtApplication.class);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ImgmtApplication.class);
    }

    @Bean
    public WebsiteListener websiteListener() {
        return new WebsiteListener();
    }
    
    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }
    
    @Bean
    public HandlerExceptionViewResolver handlerExceptionViewResolver() {
    	return new HandlerExceptionViewResolver();
    }
    
	@Bean
	public ApplicationContextHolder applicationContextHolder() {
		return new ApplicationContextHolder();
	}
	
	@Bean
	public MyBatisPageHelperInterceptor myBatisPageHelperInterceptor() {
		return new MyBatisPageHelperInterceptor();
	}
	
	@Bean
	public WebHandleInterceptorAdvisor webHandleInterceptorAdvisor() {
		return new WebHandleInterceptorAdvisor();
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}

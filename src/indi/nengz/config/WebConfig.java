package indi.nengz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;


@Configuration
@EnableWebMvc        //启动Spring MVC
@ComponentScan("indi.nengz.web")       //启动组件扫描
public class WebConfig extends WebMvcConfigurerAdapter{
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();     //配置JSP视图解析器
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}


//    @Bean
//    public ITemplateResolver  templateResolver() {                        //模板解析器
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//        templateResolver.setTemplateMode("HTML5");
//        templateResolver.setPrefix("/WEB-INF/views/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setCharacterEncoding("utf-8");
//        templateResolver.setOrder(1);
//        templateResolver.setCacheable(false);
//        return templateResolver;
//    }
//
//
//    @Bean
//    public SpringTemplateEngine templateEngine(ITemplateResolver  templateResolver) {            //模板引擎
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver);
//        return templateEngine;
//    }
//
//
//    @Bean
//    public ThymeleafViewResolver  viewResolver(TemplateEngine templateEngine) {            //Thymeleaf视图解析器
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//        viewResolver.setTemplateEngine(templateEngine);
//        viewResolver.setCharacterEncoding("utf-8");
//        return viewResolver;
//    }



	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {   //配置静态资源的处理
		configurer.enable();
	}
}
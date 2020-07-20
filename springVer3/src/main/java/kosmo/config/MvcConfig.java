package kosmo.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
	Logger logger = LoggerFactory.getLogger(MvcConfig.class);
	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
		"classpath:/static/",	
		"classpath:/resources/",	
		"classpath:/images/"	
	};
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		if(!registry.hasMappingForPattern("/**")) {
			registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
		}
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		//bean.setViewClass(JstlView.class);//jstl
		bean.setPrefix("/WEB-INF/jsp/");
		bean.setSuffix(".jsp");
		registry.viewResolver(bean);
	}
	@Bean
	public MultipartResolver multipartResolver() {
		StandardServletMultipartResolver resolver =
				new StandardServletMultipartResolver();
		return resolver;
	}	
}










package kosmo.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return null;
	}
	//D:\workspace_spring4\springVer3-2\src\main\webapp\pds
	protected void customizeRegistration
	(ServletRegistration.Dynamic registration) {
		registration.setInitParameter
		("throwExceptionIfNoHandlerFount", "true");
		MultipartConfigElement multipartConfig = 
				new MultipartConfigElement
				("C:\\workspace_spring4\\springVer3-1\\src\\main\\webapp\\pds"
						,20971520,41943040,20971520);
		registration.setMultipartConfig(multipartConfig);
	}
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter characterEncodingFilter = 
				new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);		
		return new Filter[] { characterEncodingFilter };
	}
}

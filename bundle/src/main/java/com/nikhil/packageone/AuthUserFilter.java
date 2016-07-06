package com.nikhil.packageone;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.felix.scr.annotations.sling.SlingFilter;
import org.apache.felix.scr.annotations.sling.SlingFilterScope;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Service(value=javax.servlet.Filter.class)
@Component(immediate=true,metatype=true,label="Authentication Filter",description="Connect to extranet AD to retrieve user name")

@SlingFilter(generateComponent = false, generateService = true,scope = SlingFilterScope.REQUEST, order = 100001)
public class AuthUserFilter implements Filter{
	private final static Logger logger = LoggerFactory.getLogger(AuthUserFilter.class);
    static int i=0;
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
			
			logger.debug("In doFilter..."+request);
			try {
				//super.doFilter(request, response, filterChain);
	        } catch (Exception ex) {
	            logger.error("AuthUserFilter.doFilter.fail", ex);
	        }
			//continue with filter chaining
			filterChain.doFilter(request, response);
		
	}
	
	
	public void init(FilterConfig filterConfig) throws ServletException {
		i++;
		 logger.info("init FilterConfig: " + filterConfig.getFilterName() + " ** number : " + i );
		
		
		//super.init(filterConfig);
	}
	
	protected void activate(ComponentContext context)
	{
		logger.info("************FILTER Activate");
	}

	/**
	 * DESTROY
	 * Do nothing
	 */
    public void destroy() {
    	//super.destroy();
    	logger.info("********************Destroy AuthUserFilter");
    }


	
}

package com.jsware.voteAdmin.configuration;


import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

@Configuration
public class WebConfigurations implements WebMvcConfigurer {
	
	private static final Logger log = LoggerFactory.getLogger(WebConfigurations.class);
	@Override
	public void addCorsMappings(CorsRegistry reg)
	{
		reg.addMapping("/**")
			//.allowedOrigins("**")
			.allowedMethods("POST","GET");
		
		log.info("Mapping Init");
	}
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/upload/**")
          .addResourceLocations("file:///C:/voterAdmin/upload/");
    }
//	@Bean
//	public ServletWebServerFactory  servletContainer() {
//		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
//	      @Override
//	      protected void postProcessContext(Context context) {
//	        SecurityConstraint securityConstraint = new SecurityConstraint();
//	        securityConstraint.setUserConstraint("CONFIDENTIAL");
//	        SecurityCollection collection = new SecurityCollection();
//	        collection.addPattern("/*");
//	        securityConstraint.addCollection(collection);
//	        context.addConstraint(securityConstraint);
//	      }
//	    };
//	   
//	  tomcat.addAdditionalTomcatConnectors(redirectConnector());
//	  return tomcat;
//	}
	 
//	private Connector redirectConnector() {
//	  Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//	  connector.setScheme("http");
//	  connector.setPort(8080);
//	  connector.setSecure(false);
//	  connector.setRedirectPort(8443);
//	   
//	  return connector;
//	}

}

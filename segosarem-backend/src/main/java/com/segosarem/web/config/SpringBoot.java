package com.segosarem.web.config;

import java.io.File;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
public class SpringBoot extends SpringBootServletInitializer {
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder) {
        return springApplicationBuilder
                .sources(SpringBoot.class)
                .properties(getProperties());
    }

    public static void main(String[] args) {
        //SpringApplication.run(SpringBoot.class, args);
    	
    		SpringApplicationBuilder springApplicationBuilder = new SpringApplicationBuilder(SpringBoot.class);
        springApplicationBuilder.sources(SpringBoot.class);
        springApplicationBuilder.properties(getProperties());
        springApplicationBuilder.run(args);
    }
    
    static Properties getProperties() {
		
	    	final Logger logger = LoggerFactory.getLogger(SpringBoot.class);
		Properties props = new Properties();
		String production = "Change the path here";
		File file = new File(production);
		if(file.exists()) {
			/*logger.info("*****************************************************************");
			logger.info("*********************** Production ******************************");
			logger.info("*****************************************************************");*/
			props.put("spring.config.location", "classpath:/application.properties,"+production);
		}else {
			/*logger.info("*****************************************************************");
			logger.info("*********************** Development *****************************");
			logger.info("*****************************************************************");*/
			props.put("spring.config.location", "classpath:/application.properties");
		}
		return props;
	}
}
package com.segosarem.web.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;
import org.thymeleaf.templateresolver.UrlTemplateResolver;

@Configuration
@EnableSwagger2
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages={"com.segosarem.web.webservices.api", "com.segosarem.web.webservices.db"})
public class WebConfig extends WebMvcConfigurerAdapter {

    private static final String MESSAGE_SOURCE	= 	"/WEB-INF/i18n/messages";
    private static final String VIEWS 			= 	"/WEB-INF/views/";
    
    @Bean(name = "messageSource")
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename(MESSAGE_SOURCE);
        messageSource.setCacheSeconds(5);
        return messageSource;
    }

    @Bean
    public TemplateResolver templateResolver() {
        TemplateResolver templateResolver = new ServletContextTemplateResolver();
        templateResolver.setPrefix(VIEWS);
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("LEGACYHTML5");
        templateResolver.setCacheable(false);
        return templateResolver;
    }

    @Bean
    public UrlTemplateResolver urlTemplateResolver() {
        return new UrlTemplateResolver();
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.addTemplateResolver(templateResolver());
        templateEngine.addTemplateResolver(urlTemplateResolver());
        templateEngine.addDialect(new LayoutDialect());
        templateEngine.addDialect(new SpringSecurityDialect());
        return templateEngine;
    }

    @Bean
    public ViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver vr = new ThymeleafViewResolver();
        vr.setTemplateEngine(templateEngine());
        vr.setCharacterEncoding("UTF-8");
        vr.setOrder(Ordered.HIGHEST_PRECEDENCE);
        vr.setExcludedViewNames(new String[]{"message/*"});
        return vr;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    //Swagger 2
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
            .apis(RequestHandlerSelectors
                .basePackage("com.segosarem.web.webservices.api"))
            .paths(PathSelectors.regex("/.*"))
            .build().apiInfo(apiEndPointsInfo());
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Segosarem REST API")
            .description("Segosarem REST API")
            .contact(new Contact("Paparadam Interactive Lab", "www.javaguides.net", "paparadam.interactivelab@gmail.com"))
            .license("Apache 2.0")
            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
            .version("1.0.0")
            .build();
    }
    //Swagger 2

    @Override
    public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        super.addViewControllers(registry);
        registry.addViewController("/").setViewName("forward:/index");
        registry.addViewController("index").setViewName("index");
        

    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/").addResourceLocations("/resources/**");
    }

}
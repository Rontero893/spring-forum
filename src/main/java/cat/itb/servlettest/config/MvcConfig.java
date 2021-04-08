package cat.itb.servlettest.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer
{
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/error").setViewName("error");
        registry.addViewController("/formulari").setViewName("formulari");
    }

    @Bean
    public ServletRegistrationBean<MyServlet> servletRegistrationBean() { return new ServletRegistrationBean<>(new MyServlet(), "/myServlet"); }
}

package vlasovjr.tinyUnCampus.server.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.boot.web.support.SpringBootServletInitializer;

import org.vaadin.spring.events.annotation.EnableEventBus;
import vlasovjr.tinyUnCampus.server.app.security.SecurityConfig;
import vlasovjr.tinyUnCampus.server.app.security.UserDetailsServiceImpl;
import vlasovjr.tinyUnCampus.server.backend.service.UserService;

//@Controller
//@EnableAutoConfiguration
@SpringBootApplication(scanBasePackageClasses = {
        Application.class,
        UserService.class,
        SecurityConfig.class
})
@EnableEventBus
public class Application extends SpringBootServletInitializer{

    public static final String APP_URL = "/";
    public static final String LOGIN_URL = "/login.html";
    public static final String LOGOUT_URL = "/login.html?logout";
    public static final String LOGIN_FAILURE_URL = "/login.html?error";
    public static final String LOGIN_PROCESSING_URL = "/login";

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(Application.class);
    }
}

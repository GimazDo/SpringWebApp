package  com.springproject;

import com.springproject.entities.Role;
import com.springproject.entities.User;
import com.springproject.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = "com.springproject.repos")
@SpringBootApplication
public class SpringTest extends SpringBootServletInitializer {

    public static void main(String[] args) {


        SpringApplication.run(SpringTest.class, args);
    }


}
package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;

/**
 * Created by jainvk on 7/19/15.
 */
@SpringBootApplication
@EnableConfigurationProperties
public class Application {
    @Value("${configuration.projectName}")
    void setProjectName(String projectName) {
        System.out.println("setting project name: " + projectName);
    }

    @Autowired
    void setEnvironment(Environment env) {
        System.out.println("setting environment: " + env.getProperty("configuration.projectName"));
    }

    @Autowired
    void setConfigurationProjectProperties(ConfigurationProjectProperties configurationProjectProperties) {
        System.out.println("configurationProjectProperties.projectName = " + configurationProjectProperties.getProjectName());

    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}

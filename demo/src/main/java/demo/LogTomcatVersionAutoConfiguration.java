package demo;

import org.apache.catalina.startup.Tomcat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by jainvk on 7/18/15.
 */
@Configuration
@ConditionalOnClass(Tomcat.class)
@ConditionalOnProperty(name="log-tomcat-version", matchIfMissing = false)
public class LogTomcatVersionAutoConfiguration {
    private static Log logger = LogFactory.getLog(LogTomcatVersionAutoConfiguration.class);

    @PostConstruct
    public void logTomcatVersion() {
        logger.info("\n\nHere is the Tomcat v"
        + Tomcat.class.getPackage().getImplementationVersion() + "\n\n");
    }

}

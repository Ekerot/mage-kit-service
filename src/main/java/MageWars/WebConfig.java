package MageWars;

/**
 * Created by ekerot on 2016-06-11.
 */

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan
@EnableWebMvc

public class WebConfig {

    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {

        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        Resource logResource = new ClassPathResource("log.properties");
        propertySourcesPlaceholderConfigurer.setLocation(logResource);

        return propertySourcesPlaceholderConfigurer;
    }

    public ConsoleAppender consoleAppender() {

        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setThreshold(Level.ALL);
        PatternLayout patternLayout = new PatternLayout();
        patternLayout.setConversionPattern("%m%n");
        consoleAppender.setLayout(patternLayout);

        return consoleAppender;
    }

}

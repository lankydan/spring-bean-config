package lankydan.tutorial.beans.config;

import lankydan.tutorial.beans.MyBean;
import lankydan.tutorial.beans.MyBeanWithInjectionImpl;
import lankydan.tutorial.beans.MyBeanWithPropertiesImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppWithPropertyInjectionConfig {

  // The @Value annotation takes a reads a value from a properties file allowing them to be changed
  // from a central location rather than be directly written into the code itself. These properties
  // are currently being read out of "application.properties"
  @Value("${propertyOne}")
  private String propertyOne;

  @Value("${propertyTwo}")
  private String propertyTwo;

  @Bean
  public MyBean myBeanWithProperties() {
    return new MyBeanWithPropertiesImpl(propertyOne, propertyTwo);
  }

  // The properties can be passed in via method parameters.
  @Bean
  public MyBean myOtherBeanWithProperties(
      @Value("${propertyOne}") final String propertyOne,
      @Value("${propertyTwo}") final String propertyTwo) {
    return new MyBeanWithPropertiesImpl(propertyOne, propertyTwo);
  }

  @Bean
  public MyBean myBeanWithMethodInjectedProperties() {
    return new MyBeanWithInjectionImpl(myOtherBeanWithProperties(null, null));
  }
}

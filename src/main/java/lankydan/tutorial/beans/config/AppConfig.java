package lankydan.tutorial.beans.config;

import lankydan.tutorial.beans.MyBean;
import lankydan.tutorial.beans.MyBeanImpl;
import lankydan.tutorial.beans.MyBeanWithoutInterface;
import lankydan.tutorial.beans.MyOtherBeanImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Marks the class as a configuration class allowing beans to be defined within it.
@Configuration
public class AppConfig {

  // a beans default scope is "Singleton" and uses the ID / name of the bean to
  // identify the single instance in the context. There can still be multiple
  // beans of the same interface defined, but as they have different IDs they are
  // still referred to being Singletons

  // @Bean marks the method below to create a bean with the name "myBean" (the name is
  // taken from the method name) and returns an instance of the "MyBeanImpl" class.
  // The method definition marks the return type as "MyBean" but "MyBeanImpl" could also be used.
  @Bean
  public MyBean myBean() {
    return new MyBeanImpl();
  }

  // The name property of the @Bean annotation can be used to give the defined bean different
  // names / aliases if desired. Any names defined in this property will override the bean name
  // that is inferred from the method name.
  @Bean({"myOtherBean", "beanNameTwo"})
  public MyBean myOtherBeanWithDifferentName() {
    return new MyOtherBeanImpl();
  }

  // The bean below does not need to be defined as the @Component annotation marked on the
  // "MyBeanWithoutInterface" allows it to be picked up by Spring's auto detection and creates
  // the bean. Even through the implementations of "MyBean" are marked with @Component due to
  // there being two implementations the beans need to be defined manually.

  //	@Bean
  //	public MyBeanWithoutInterface myBeanWithoutInterface() {
  //		return new MyBeanWithoutInterface();
  //	}

}

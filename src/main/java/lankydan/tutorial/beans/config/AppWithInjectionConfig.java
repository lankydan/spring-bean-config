package lankydan.tutorial.beans.config;

import lankydan.tutorial.beans.MyBean;
import lankydan.tutorial.beans.MyBeanWithInjectionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppWithInjectionConfig {

  @Autowired private MyBean myOtherBean;

  // The bean "myBean" is injected into "myBeanWithInjection" as it uses constructor injection
  // instead of using @Autowired to inject the bean in inside it's implementation. Even though
  // "myBean" was defined inside another @Configuration class as it exists within the context it
  // can still be used for injection in this class.
  @Bean
  public MyBean myBeanWithInjection(final MyBean myBean) {
    return new MyBeanWithInjectionImpl(myBean);
  }

  // A benefit of injecting dependencies in this was is that it makes it clear what is being
  // injected into the created bean. Using @Autowired hides this which can make it more prone to
  // mistakes.

  // @Qualifier can be used in the constructor to select the correct bean if a different bean
  // name is passed into the constructor.
  @Bean
  public MyBean myOtherBeanWithInjection(@Qualifier("myOtherBean") final MyBean myBean) {
    return new MyBeanWithInjectionImpl(myBean);
  }

  // A bean can also be @Autowired into this @Configuration class so it can be used with the created
  // bean instead of being passed in via the method.
  @Bean
  public MyBean myBeanWithAutowiredDependency() {
    return new MyBeanWithInjectionImpl(myOtherBean);
  }

  @Bean
  public MyBean myBeanWithMethodInjectedDependency() {
    return new MyBeanWithInjectionImpl(myBeanWithAutowiredDependency());
  }
}

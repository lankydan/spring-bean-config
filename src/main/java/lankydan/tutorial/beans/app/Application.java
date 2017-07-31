package lankydan.tutorial.beans.app;

import lankydan.tutorial.beans.MyBean;
import lankydan.tutorial.beans.MyBeanWithoutInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.Resource;

@SpringBootApplication
@ComponentScan(basePackages = "lankydan.tutorial.beans")
public class Application implements CommandLineRunner {

  // No annotation is required because the variable name matched the bean name.

  // When injecting in a bean using the interface name instead of the name of
  // an implementation allows the bean definition to change without effecting
  // configuration in other areas.

  // @Qualifier("myBean") would be used if the variable name varied
  @Autowired private MyBean myBean;

  // @Qualifier(<name of bean>) is required when there are multiple beans defined for the same interface
  // and the name of the variable name does not match the bean name.

  // @Resource(name = <name of bean>) can be used instead of the @Autowired and @Qualifier annotation combination

  // @Autowired
  // @Qualifier("myOtherBean")
  @Resource(name = "myOtherBean")
  private MyBean myOtherBeanWithWrongName;

  @Autowired
  private MyBeanWithoutInterface myBeanWithoutInterface;

  @Autowired
  private MyBean myBeanWithMethodInjectedDependency;

  @Autowired
  private MyBean myBeanWithMethodInjectedProperties;

  public static void main(final String args[]) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(final String... s) {
    myBean.someMethod();
    myOtherBeanWithWrongName.someMethod();
    myBeanWithoutInterface.someMethod();
    myBeanWithMethodInjectedDependency.someMethod();
    myBeanWithMethodInjectedProperties.someMethod();
  }
}

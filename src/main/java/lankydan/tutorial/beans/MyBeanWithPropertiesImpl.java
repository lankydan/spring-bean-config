package lankydan.tutorial.beans;

import org.springframework.stereotype.Component;

@Component
public class MyBeanWithPropertiesImpl implements MyBean {

  // @Value can be used directly on these properties instead of injecting in via the constructor
  // but like using @Autowired, it can hide what is going on with the beans and leading to possible errors
  private final String propertyOne;
  private final String propertyTwo;

  public MyBeanWithPropertiesImpl(final String propertyOne, final String propertyTwo) {
    this.propertyOne = propertyOne;
    this.propertyTwo = propertyTwo;
  }

  @Override
  public void someMethod() {
    System.out.println(
        getClass()
            + ".someMethod() with properties: propertyOne = "
            + propertyOne
            + ", propertyTwo = "
            + propertyTwo);
  }
}

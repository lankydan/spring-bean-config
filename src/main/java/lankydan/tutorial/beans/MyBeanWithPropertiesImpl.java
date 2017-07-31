package lankydan.tutorial.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// The @Component annotation is preventing the @Value properties from being injected in correct, as
// it seems to expect them to be beans
// This is because @Component makes the class available for auto scanning and creation and because,
// the @Value annotation has not been included to the constructor arguments, adding the annotation
// makes it expect a bean of type String and therefore fails as no such thing exists.
//@Component
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

package lankydan.tutorial.beans;

import org.springframework.stereotype.Component;

@Component
public class MyBeanImpl implements MyBean {

  @Override
  public void someMethod() {
    System.out.println(getClass() + ".someMethod()");
  }
}

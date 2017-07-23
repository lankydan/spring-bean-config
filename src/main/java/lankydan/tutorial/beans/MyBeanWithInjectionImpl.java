package lankydan.tutorial.beans;

import org.springframework.stereotype.Component;

@Component
public class MyBeanWithInjectionImpl implements MyBean {

  private final MyBean myBean;

  // constructor injection used instead of @Autowired on the property
  public MyBeanWithInjectionImpl(final MyBean myBean) {
    this.myBean = myBean;
  }

  @Override
  public void someMethod() {
    System.out.print("from injection: ");
    myBean.someMethod();
  }
}

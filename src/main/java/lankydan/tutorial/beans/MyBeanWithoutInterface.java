package lankydan.tutorial.beans;

import org.springframework.stereotype.Component;

// A bean can still be created from a class without an interface but it is good practice to
// implement an interface so the implementation can be switched out at a later time without having
// to change extra configuration code.
@Component
public class MyBeanWithoutInterface {

	public void someMethod() {
		System.out.println(getClass() + ".someMethod()");
	}

}

package ktaiquiz.form;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;

@Component(instance = InstanceType.REQUEST)
public class AdminForm {

	public String password;
	public String questionNumber;
}


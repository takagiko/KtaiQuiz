package ktaiquiz.form;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

public class RegisterForm {

	public String userid;
	public String password;

	public String name;
	
	public ActionMessages validate() {
		ActionMessages errors = new ActionMessages();
		if (name == null || name.length() == 0) {
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.required", "名前"));
		}
		return errors;
	}

}


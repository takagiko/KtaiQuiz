package ktaiquiz.action;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import ktaiquiz.dto.ConditionDto;
import ktaiquiz.form.RegisterForm;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.ActionMessagesUtil;


public class RegisterAction {

	@Resource
	public ConditionDto conditionDto;

    @ActionForm
    @Resource
    protected RegisterForm registerForm;

	@Resource
	protected ServletContext application;

	@Resource
    public HttpServletRequest request;

	public int questionNumber = 1;

	@Execute(validate = "validate", urlPattern = "{userid}/{password}", input="/register.jsp")
	public String index() {

		// ユーザIDとニックネームの対応マップに追加
		conditionDto.userMap.put(registerForm.userid, registerForm.name);

		ActionMessages errors = new ActionMessages();
		errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("info.welcome", registerForm.name));
		ActionMessagesUtil.addErrors(request, errors);

		return "/beforeAnswer.jsp";
	}
}

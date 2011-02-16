package ktaiquiz.action;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import ktaiquiz.dto.ConditionDto;
import ktaiquiz.form.AdminForm;

import org.apache.commons.codec.digest.DigestUtils;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;


public class AdminSetWaitingAction {

	@Resource
	public ConditionDto conditionDto;

	@ActionForm
	@Resource
	public AdminForm adminForm;

	@Resource
	protected ServletContext application;

	@Resource
    public HttpServletRequest request;

	@Execute(validator = false, urlPattern = "{password}/{questionNumber}")
	public String index() throws Exception {

		if (DigestUtils.md5Hex("admin" + ConditionDto.SALT).substring(0, 4).equals(adminForm.password) == false) {
			return "/error.jsp";
		}

		conditionDto.questionNumber = Integer.parseInt(adminForm.questionNumber);
		conditionDto.isAnswerAccepting = false;

		return "/admin/" + adminForm.password;
	}
}
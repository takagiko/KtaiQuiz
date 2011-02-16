package ktaiquiz.action;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import ktaiquiz.InitPlugIn;
import ktaiquiz.dto.ConditionDto;
import ktaiquiz.form.AdminForm;

import org.apache.commons.codec.digest.DigestUtils;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;


public class AdminResetAllAction {

	@Resource
	public ConditionDto conditionDto;

	@ActionForm
	@Resource
	public AdminForm adminForm;

	@Resource
	protected ServletContext application;

	@Execute(validator = false, urlPattern = "{password}")
	public String index() throws Exception {

		if (DigestUtils.md5Hex("admin" + ConditionDto.SALT).substring(0, 4).equals(adminForm.password) == false) {
			return "/error.jsp";
		}
		conditionDto = new ConditionDto();
		InitPlugIn.initStatus(application, conditionDto);
		return "/admin/" + adminForm.password;
	}
}
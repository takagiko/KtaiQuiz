package ktaiquiz.action;

import javax.annotation.Resource;

import ktaiquiz.dto.ConditionDto;
import ktaiquiz.form.AdminForm;

import org.apache.commons.codec.digest.DigestUtils;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;


public class AdminAction {

	@Resource
	public ConditionDto conditionDto;

	@ActionForm
	@Resource
	public AdminForm adminForm;
	
	@Execute(validator = false, urlPattern = "{password}")
	public String index() throws Exception {

		if (DigestUtils.md5Hex("admin" + ConditionDto.SALT).substring(0, 4).equals(adminForm.password) == false) {
			return "/error.jsp";
		}

		return "/admin.jsp";
	}
}
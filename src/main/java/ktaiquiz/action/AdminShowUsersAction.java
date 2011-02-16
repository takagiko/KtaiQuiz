package ktaiquiz.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import ktaiquiz.dto.ConditionDto;
import ktaiquiz.form.AdminForm;

import org.apache.commons.codec.digest.DigestUtils;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;


public class AdminShowUsersAction {

	@Resource
	public ConditionDto conditionDto;

	@ActionForm
	@Resource
	public AdminForm adminForm;

	@Resource
    public HttpServletRequest request;

	public List<String> idList = new ArrayList<String>();
	public List<String> nameList = new ArrayList<String>();

	@Execute(validator = false, urlPattern = "{password}")
	public String index() throws Exception {

		if (DigestUtils.md5Hex("admin" + ConditionDto.SALT).substring(0, 4).equals(adminForm.password) == false) {
			return "/error.jsp";
		}

		for (String key : conditionDto.userMap.keySet()) {
			idList.add(key);
			nameList.add(conditionDto.userMap.get(key));
		}
		return "/admin_users.jsp";
	}
}
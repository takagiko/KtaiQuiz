package ktaiquiz.action;

import ktaiquiz.dto.ConditionDto;

import org.apache.commons.codec.digest.DigestUtils;
import org.seasar.struts.annotation.Execute;


public class IndexAction {

	public String userid;
	public String password;

	@Execute(validator = false)
	public String index() {
		
        return "index.jsp";
	}

	@Execute(validator = false, urlPattern = "{userid}/{password}")
	public String first() throws Exception {

		if (userid == null) {
			return "/error.jsp";
		} else if (userid.length() != 4) {
			return "/error.jsp";
		}

		String pass = DigestUtils.md5Hex(userid + ConditionDto.SALT).substring(0, 4);
		if (pass.equals(password) == false) {
			return "/error.jsp";
		}

		return "/register.jsp";
	}

}


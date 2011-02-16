package ktaiquiz.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import ktaiquiz.dto.ConditionDto;
import ktaiquiz.dto.ConditionDto.Question;
import ktaiquiz.dto.ConditionDto.Question.Answer;
import ktaiquiz.form.AdminForm;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.Bag;
import org.apache.commons.collections.bag.HashBag;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;


public class AdminShowGraphAction {

	@Resource
	public ConditionDto conditionDto;

	@ActionForm
	@Resource
	public AdminForm adminForm;

	@Resource
	protected ServletContext application;

	@Resource
    public HttpServletRequest request;
	
	public List<Integer> result = new ArrayList<Integer>();
	public List<Integer> percent = new ArrayList<Integer>();

	@Execute(validator = false, urlPattern = "{password}/{questionNumber}")
	public String index() throws Exception {

		if (DigestUtils.md5Hex("admin" + ConditionDto.SALT).substring(0, 4).equals(adminForm.password) == false) {
			return "/error.jsp";
		}

		Question q = conditionDto.questions.get(Integer.parseInt(adminForm.questionNumber) - 1);
		Bag bag = new HashBag();
		for (String key : q.answers.keySet()) {
			Answer a = q.answers.get(key);
			for (Integer i : a.answer) {
				bag.add(i);
			}
		}

		for (int i = 0 ; i < q.choices.size() ; i++) {
			result.add(bag.getCount(i + 1));
			if (bag.size() == 0) {
				percent.add(0);
			} else {
				percent.add(100 * bag.getCount(i + 1) / bag.size());
			}
		}

		return "/admin_graph.jsp";
	}
}
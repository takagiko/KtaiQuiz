package ktaiquiz.action;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import ktaiquiz.dto.ConditionDto;
import ktaiquiz.form.ShowForm;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.ActionMessagesUtil;


public class ShowAction {

	@Resource
	public ConditionDto conditionDto;

	@ActionForm
	@Resource
	protected ShowForm showForm;

	@Resource
	protected ServletContext application;

	@Resource
    public HttpServletRequest request;

	@Execute(validator = false, urlPattern = "{userid}/{password}/{questionNumber}")
	public String index() {
		
		// 1つ前の問題の受付中なら
		if (conditionDto.questionNumber + 1 == Integer.parseInt(showForm.questionNumber)) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.notacceptingyet", showForm.questionNumber));
			ActionMessagesUtil.addErrors(request, errors);
			return "/beforeAnswer.jsp";
		}

		// m != n 問目受付{中|前}なら
		if (conditionDto.questionNumber != Integer.parseInt(showForm.questionNumber)) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.notaccepting", showForm.questionNumber));
			ActionMessagesUtil.addErrors(request, errors);
			showForm.questionNumber = Integer.toString(conditionDto.questionNumber);
			return "/beforeAnswer.jsp";
		}

		// m == n 問目受付前なら
		if (conditionDto.isAnswerAccepting == false) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.notacceptingyet", showForm.questionNumber));
			ActionMessagesUtil.addErrors(request, errors);
			return "/beforeAnswer.jsp";
		}

		// m == n 問目受付中なら
		return "/question.jsp";
	}
}

package ktaiquiz.action;

import java.util.Date;
import java.util.HashSet;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import ktaiquiz.dto.ConditionDto;
import ktaiquiz.dto.ConditionDto.Question;
import ktaiquiz.dto.ConditionDto.Question.Answer;
import ktaiquiz.form.AnswerForm;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.ActionMessagesUtil;


public class AnswerAction {

	@Resource
	public ConditionDto conditionDto;

	@ActionForm
	@Resource
	protected AnswerForm answerForm;

	@Resource
	protected ServletContext application;

	@Resource
    public HttpServletRequest request;

	@Execute(validator = false, urlPattern = "{userid}/{password}/{questionNumber}")
	public String index() {

		// m != n 問目受付中なら
		if (conditionDto.questionNumber != Integer.parseInt(answerForm.questionNumber)) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.notaccepting", answerForm.questionNumber));
			ActionMessagesUtil.addErrors(request, errors);
			answerForm.questionNumber = Integer.toString(conditionDto.questionNumber);
			if (conditionDto.isAnswerAccepting == true) {
				return "/question.jsp";
			} else {
				return "/beforeAnswer.jsp";
			}
		}

		// m 問目受付前なら
		if (conditionDto.isAnswerAccepting == false) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.notacceptingyet", answerForm.questionNumber));
			ActionMessagesUtil.addErrors(request, errors);
			return "/beforeAnswer.jsp";
		}
		
		// 回答数が正しくないなら
		Question question = conditionDto.questions.get(conditionDto.questionNumber - 1); 
		if (answerForm.answer == null || question.rightAnswer.size() != answerForm.answer.size()) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.nganswer", question.rightAnswer.size() ) );
			ActionMessagesUtil.addErrors(request, errors);
			return "/question.jsp";
		}

		// すべてOKなら回答を登録
		Answer answer = question.new Answer();
		answer.userId = answerForm.userid;
		answer.answerTime = new Date();
		answer.elapsedTime = answer.answerTime.getTime() - conditionDto.answerAcceptStartTime.getTime();
		answer.score = 0;
		answer.answer = new HashSet<Integer>();
		for (String sAns : answerForm.answer) {
			int iAns = Integer.parseInt(sAns);
			answer.answer.add(iAns);
			if (question.rightAnswer.contains(iAns) == true) {
				answer.score += question.score;
			}
		}
		question.answers.put(answerForm.userid, answer);
		return "/finishAnswer.jsp";
	}
}

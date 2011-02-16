package ktaiquiz.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import ktaiquiz.dto.ConditionDto;
import ktaiquiz.dto.ConditionDto.Question;
import ktaiquiz.dto.ConditionDto.Question.Answer;
import ktaiquiz.form.AdminForm;

import org.apache.commons.codec.digest.DigestUtils;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;


public class AdminShowResultAction {

	@Resource
	public ConditionDto conditionDto;

	@ActionForm
	@Resource
	public AdminForm adminForm;

	@Resource
	protected ServletContext application;

	@Resource
    public HttpServletRequest request;

	public List<UserForResult> result;

	@Execute(validator = false, urlPattern = "{password}")
	public String index() throws Exception {

		if (DigestUtils.md5Hex("admin" + ConditionDto.SALT).substring(0, 4).equals(adminForm.password) == false) {
			return "/error.jsp";
		}

		Map<String, UserForResult> resultMap = new HashMap<String, UserForResult>();
		for (String key : conditionDto.userMap.keySet()) {
			UserForResult user = new UserForResult();
			user.id = key;
			user.name = conditionDto.userMap.get(key);
			resultMap.put(key, user);
		}

		// すべての回答を集計する
		for (Question q : conditionDto.questions) {
			for (String s : q.answers.keySet()) {
				Answer a = q.answers.get(s);
				UserForResult user = resultMap.get(a.userId);
				if (user == null) continue;
				user.score += a.score;
				user.elapsedTime.add(a.elapsedTime);
			}
		}
		// 平均時間を計算して、Map を List に詰め直す。
		result = new ArrayList<UserForResult>();
		for (UserForResult user : resultMap.values()) {
			long allTime = 0;
			for (Long t : user.elapsedTime) {
				allTime += t;
			}
			if (user.elapsedTime.size() == 0) {
				// 全く無回答のユーザは、平均時間を9999秒とする。
				user.avgTime = 9999;
			} else {
				user.avgTime = allTime / user.elapsedTime.size();
			}
			result.add(user);
		}
		// ソート
		Collections.sort(result);
		return "/admin_result.jsp";
	}

	public class UserForResult implements Comparable<UserForResult> {
		public String id;
		public String name;
		public int score = 0;
		public List<Long> elapsedTime = new ArrayList<Long>();
		public long avgTime = 0;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

		public List<Long> getElapsedTime() {
			return elapsedTime;
		}

		public void setElapsedTime(List<Long> elapsedTime) {
			this.elapsedTime = elapsedTime;
		}

		public long getAvgTime() {
			return avgTime;
		}

		public void setAvgTime(long avgTime) {
			this.avgTime = avgTime;
		}

		@Override
		public int compareTo(UserForResult o) {
			if (score < o.score) {
				return 2;
			} else if (score > o.score) {
				return -2;
			} else {
				if (avgTime > o.avgTime) {
					return 1;
				} else if (avgTime < o.avgTime) {
					return -1;
				}
			}
			return 0;
		}
	}
}
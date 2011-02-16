package ktaiquiz.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;

@Component(instance = InstanceType.APPLICATION)
public class ConditionDto implements Serializable {

	private static final long serialVersionUID = -5155346819334609154L;

	/** ユーザIDをハッシュするときに混ぜるSALT */
	public static final String SALT = "amorem perpetuum";

	/** 現在の質問番号(1から始まる) */
	public int questionNumber = 1;

	/** true なら回答受付中。false なら回答受付前 */
	public boolean isAnswerAccepting = false;

	/** 回答受付開始時間 */
	public Date answerAcceptStartTime;

	/** ユーザIDとユーザ名の対応表 */
	public Map<String, String> userMap = Collections.synchronizedMap( new HashMap<String, String>() );

	/** 質問のリスト */
	public List<Question> questions = new ArrayList<Question>();
	
	/*
	 * 質問クラス
	 */
	public class Question implements Serializable {

		private static final long serialVersionUID = 8157135233511459711L;

		/** 質問文 */
		public String question;
		
		/** 選択肢 */
		public List<String> choices = new ArrayList<String>();
		
		/** 各人の回答 */
		public Map<String, Answer> answers = new HashMap<String, Answer>();
		
		/** 正解 */
		public List<Integer> rightAnswer = new ArrayList<Integer>();
		
		/** 正解時の点数（正解選択肢１つあたり） */
		public int score;
		
		/*
		 * 回答クラス
		 */
		public class Answer implements Serializable {

			private static final long serialVersionUID = -8378321908666255899L;

			/** 回答をしたユーザ */
			public String userId;
			
			/** 回答 */
			public Set<Integer> answer;
			
			/** 回答時間 */
			public Date answerTime;
			
			/** 得た得点 */
			public int score;
			
			/** 所要時間 */
			public long elapsedTime;
		}
	}

	/*
	 * 初期化メソッド
	 */
	public void init(Properties p) {
		int qNum = 1;
		while (true) {
			ConditionDto.Question q = new Question();

			q.question = p.getProperty("q" + qNum + ".question");
			if (q.question == null) {
				break;
			}

			q.score = Integer.parseInt( p.getProperty("q" + qNum + ".score") );
			
			for (int i = 1 ; p.getProperty("q" + qNum + ".choice" + i) != null ; i++ ) {
				q.choices.add(p.getProperty("q" + qNum + ".choice" + i));
			}
			
			String answers = p.getProperty("q" + qNum + ".answer");
			for (String answer : answers.split(",")) {
				q.rightAnswer.add(Integer.parseInt(answer));
			}

			questions.add(q);
			qNum++;
		}
	}
}

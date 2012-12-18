package beans;

import java.util.List;

public class Question {

	private String wording;
	private List<Answer> answers;
	private int num;

	public Question(String wording, List<Answer> answers, int num) {
		super();
		this.wording = wording;
		this.answers = answers;
		this.num = num;
	}

	public String getWording() {
		return wording;
	}

	public void setWording(String wording) {
		this.wording = wording;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}

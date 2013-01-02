package algorithm;

import java.util.List;

import beans.Exam;

public class ExamGenerator {

	private List<Exam> exams;
	private Exam mainExam;
	
	
	public ExamGenerator(Exam mainExam) {
		this.mainExam = mainExam;
	}


	public List<Exam> getExams() {
		return exams;
	}


	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}


	public Exam getMainExam() {
		return mainExam;
	}


	public void setMainExam(Exam mainExam) {
		this.mainExam = mainExam;
	}
	
	
	
	
	
}

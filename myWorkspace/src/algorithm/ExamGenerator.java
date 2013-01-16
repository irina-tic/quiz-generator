package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import beans.Answer;
import beans.Exam;
import beans.Question;

//class ExamGenerator contains a list with the exams
//it has a mainExam from which the other exams will be derived

public class ExamGenerator {

	private List<Exam> exams;
	private Exam mainExam;
	int numExam;

	public ExamGenerator(Exam mainExam, int numExam) {
		this.mainExam = mainExam;
		this.numExam = numExam;
		this.exams = doExams(mainExam, numExam);
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
	//set and get methods are implemented as the mainExam is of type private

	public List<Exam> doExams(Exam exam, int numExam) {
		List<Exam> ret = new ArrayList<Exam>();
		// We have to create different exams with different order and adding
		// them to the exams list.

		// We obtain the questions
		List<Question> mainList = exam.getQuestions();

		// Starting to random order
		for (int i = 0; i < numExam; i++) {
			

			// Creating the new Question list with different order
			//by using shuffle method
			Collections.shuffle(mainList);
			
		//creating a new answer list too in different order so that the exams are different	
			for(Question e : mainList){
				List<Answer> answers = e.getAnswers();
				
				
				if(e.getAnswers()!=null)
				Collections.shuffle(answers);
			}
			
			List<Question> list = new ArrayList<>();
			list.addAll(mainList);

			// Creating the exam
			Exam examAux = new Exam(list);
			ret.add(examAux);

		}
		return ret;
	}

}

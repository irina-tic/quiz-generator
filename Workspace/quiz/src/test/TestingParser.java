package test;

import beans.Answer;
import beans.Question;
import input.Parser;

public class TestingParser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Parser test = new Parser("D:\\XML_EntryFile.xml");
		for(Question e: test.getQuestions()){
			System.out.println(e.getWording());
			for(Answer aux:e.getAnswers()){
				System.out.println(aux.toString());	
				
			}
		}
		

	}

}

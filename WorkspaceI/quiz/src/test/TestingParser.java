package test;

import java.io.IOException;

import input.Parser;

import javax.swing.JOptionPane;

import output.OutPut;
import algorithm.ExamGenerator;
import beans.Exam;

public class TestingParser {

	/**
	 * @param args

	 */

	//main method uses 3 important methods:
	// 1. Parser method for parsing the xml file
	// 2. ExamGenerator method which generates our exams
	// 3. GenerateHTML method for saving our results 
	
	public static void main(String[] args) {
		
		Parser test = new Parser("D:\\XML_EntryFile.xml");
		//exam method has in input the result from the parser and the number of the exams
		ExamGenerator test2 = new ExamGenerator(new Exam(test.getQuestions()), 6);
		OutPut out = new OutPut(test2);
		out.generateHTML();
		try{
			
            Process p = Runtime.getRuntime().exec("C:\\Program Files\\Mozilla Firefox\\firefox.exe "+"file:///C:/Users/Irina/Documents/GitHub/quiz-generator/Workspace/quiz/reporte.html");
		} catch(IOException e1){
			System.out.print(e1.toString());
		} 
	}

}

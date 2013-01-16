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

		Parser test = null;
		
	    //verifying if the argument vector is empty
		if(0>args.length){
			//if no argument: print message + exit
			System.out.println("No arguments");
			System.exit(1);
		}

		//going through the argument vector
		for (int i = 0; i < args.length; i++)
		{

			//initializing test with elements of the vector
			test = new Parser(args[i]);
			//exam method has in input the result from the parser and the number of the exams
			ExamGenerator test2 = new ExamGenerator(new Exam(test.getQuestions()), 6);
			OutPut out = new OutPut(test2);
            //creating exams file for subject i
			String t = "reporte_"+i+".html";
            //creating exam answers file for subject i
			String t1 = "reportea_"+i+".html";
            //calling the method to generate the 2 files
			out.generateHTML(t,t1);
			try{
				//html file for students
				Process p = Runtime.getRuntime().exec("C:\\Program Files\\Mozilla Firefox\\firefox.exe reportea_"+i+".html");
				//html file for teachers
				Process p2 = Runtime.getRuntime().exec("C:\\Program Files\\Mozilla Firefox\\firefox.exe reporte_"+i+".html");
			} catch(IOException e1){
				System.out.print(e1.toString());
			} 

		}
	}

}

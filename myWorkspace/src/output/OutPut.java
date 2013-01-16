package output;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Random;

import algorithm.ExamGenerator;
import beans.Answer;
import beans.Exam;
import beans.Question;

public class OutPut {

	private ExamGenerator exams;

	public OutPut(ExamGenerator exams) {
		super();
		this.exams = exams;
	}

	public ExamGenerator getExams() {
		return exams;
	}

	public void setExams(ExamGenerator exams) {
		this.exams = exams;
	}

	public void generateHTML(String st, String st1) {

		try {

			//STUDENT COPY
			FileWriter archivo = new FileWriter(st);

			PrintWriter escritura = new PrintWriter(archivo);

			//TEACHER COPY

			FileWriter archivo2 = new FileWriter(st1);

			PrintWriter escritura2 = new PrintWriter(archivo2);



			// we write the main structure a HTML file

			//STUDENT COPY

			escritura
			.println("<html lang='en'><head><meta charset='utf-8' /><!-- Always force latest IE rendering engine (even in intranet) & Chrome FrameRemove this if you use the .htaccess --><meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1' /><title>Exams</title><meta name='description' content='' /><meta name='author' content='DAVID' /><meta name='viewport' content='width=device-width; initial-scale=1.0' />		<!-- Replace favicon.ico & apple-touch-icon.png in the root of your domain and delete these references --><link rel='shortcut icon' href='/favicon.ico' /><link rel='apple-touch-icon' href='/apple-touch-icon.png' /></head>");
			escritura.println(" <body>");

			//TEACHER COPY
			escritura2
			.println("<html lang='en'><head><meta charset='utf-8' /><!-- Always force latest IE rendering engine (even in intranet) & Chrome FrameRemove this if you use the .htaccess --><meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1' /><title>Exam - Answers</title><meta name='description' content='' /><meta name='author' content='DAVID' /><meta name='viewport' content='width=device-width; initial-scale=1.0' />		<!-- Replace favicon.ico & apple-touch-icon.png in the root of your domain and delete these references --><link rel='shortcut icon' href='/favicon.ico' /><link rel='apple-touch-icon' href='/apple-touch-icon.png' /></head>");
			escritura2.println(" <body>");


			Integer i = 0;
			for (Exam e : this.exams.getExams()) {

				//STUDENT COPY
				escritura.println(" <div>");
				escritura.println(" <header>");

				escritura.println(" <h1><center>Exam</center></h1>");
				escritura.println(" <h6><center>Serial: " + i
						+ "</center></h6>");
				escritura.println(" </header>");
				escritura.println(" <div>");
				escritura.println(" <nav>");



				//TEACHER COPY
				escritura2.println(" <div>");
				escritura2.println(" <header>");

				escritura2.println(" <h1><center>Exam - Answers</center></h1>");
				escritura2.println(" <h6><center>Serial: " + i
						+ "</center></h6>");
				escritura2.println(" </header>");
				escritura2.println(" <div>");
				escritura2.println(" <nav>");
				i++;



				for (Question aux : e.getQuestions()) {
					//STUDENT COPY

					escritura.println("<h2>" + aux.getWording() + "</h2>");

					//TEACHER COPY

					escritura2.println("<h2>" + aux.getWording() + "</h2>");

					if (aux.getAnswers() != null) {

						//SHUFFLE THE ANSWERS
						Random ran = new Random();
						Collections.shuffle(aux.getAnswers(),ran);

						for (Answer ans : aux.getAnswers()) {
							if(ans.isFalse()==false){
								//STUDENT COPY
								escritura.println("<p>" + ans.getSentence() + "</p>");

								//TEACHER COPY
								escritura2.println("<p><ins>" + ans.getSentence() + "</ins></p>");	
							}else{
								//STUDENT COPY

								escritura.println("<p>" + ans.getSentence() + "</p>");


								//TEACHER COPY

								escritura2.println("<p>" + ans.getSentence() + "</p>");
							}
						}

					}else{
						//STUDENT COPY

						escritura.println("<br>");
						escritura.println("<br>");
						escritura.println("<br>");
						escritura.println("<br>");


						//TEACHER COPY

						escritura2.println("<br>");
						escritura2.println("<br>");
						escritura2.println("<br>");
						escritura2.println("<br>");



					}
					//STUDENT COPY
					escritura.println(" <hr>");

					//TEACHER COPY
					escritura2.println(" <hr>");
				}

				//STUDENT COPY

				escritura.println(" </nav>");
				escritura.println(" </div>");
				escritura.println(" </div>");


				//TEACHER COPY
				escritura2.println(" </nav>");
				escritura2.println(" </div>");
				escritura2.println(" </div>");

			}//end exam

			//STUDENT COPY
			escritura.println(" </body>");
			escritura.println("</html>");


			//TEACHER COPY
			escritura2.println(" </body>");
			escritura2.println("</html>");

			// to be sure we close the file
			archivo.close();
			archivo2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

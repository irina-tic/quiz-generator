package output;

import java.io.FileWriter;
import java.io.PrintWriter;

import algorithm.ExamGenerator;
import beans.Answer;
import beans.Exam;
import beans.Question;

//the Output class is used for saving the generated exams in a user-friendly form
//in order to do this it is used the ExamGenerator class
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

//generateHTML is a method for generating and saving the created exams
	public void generateHTML() {

		try {
			//create a new file
			FileWriter archivo = new FileWriter("reporte.html");

			PrintWriter escritura = new PrintWriter(archivo);

			//write a text file with the structure of the html file by creating each tag

			escritura.println("<html lang='en'><head><meta charset='utf-8' /><!-- Always force latest IE rendering engine (even in intranet) & Chrome FrameRemove this if you use the .htaccess --><meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1' /><title>Exams</title><meta name='description' content='' /><meta name='author' content='DAVID' /><meta name='viewport' content='width=device-width; initial-scale=1.0' />		<!-- Replace favicon.ico & apple-touch-icon.png in the root of your domain and delete these references --><link rel='shortcut icon' href='/favicon.ico' /><link rel='apple-touch-icon' href='/apple-touch-icon.png' /></head>");
			escritura.println(" <body>");

			//creating the body of the html file
			Integer i = 0;
			for (Exam e : this.exams.getExams()) {

				escritura.println(" <div>");
				escritura.println(" <header>");

				escritura.println(" <h1><center>Exam</center></h1>");
				escritura.println(" <h6><center>Serial: " + i
						+ "</center></h6>");
				escritura.println(" </header>");
				escritura.println(" <div>");
				escritura.println(" <nav>");
				i++;
				for (Question aux : e.getQuestions()) {

					escritura.println("<h2>" + aux.getWording() + "</h2>");
					if (aux.getAnswers() != null) {
						for (Answer ans : aux.getAnswers()) {
							escritura.println("<p>" + ans.getSentence() + "</p>");
						}
						escritura.println(" <hr>");
					}

				}
				escritura.println(" </nav>");
				escritura.println(" </div>");
				escritura.println(" </div>");

			}

			escritura.println(" </body>");
			escritura.println("</html>");
			
			//we're making sure that the archive is closed
			
			archivo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

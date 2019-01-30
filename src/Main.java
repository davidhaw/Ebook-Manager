import java.io.File;
import java.util.Scanner;
import proprietaryDependancies.ListFiles;
import org.zeroturnaround.zip.*;
import org.slf4j.*;
public class Main {

	 public static void main(String[] args) {
		
		 //The User Input Int. Should be able to be reused for every user input. 
		 int uI;
		 
		 //Inits File and scanner
		 Scanner scanner = new Scanner(System.in);
		 File folder = new File("./Ebooks");

		 //The first lines the User sees
		 System.out.println("Welcome to Ebook Manager");
		 System.out.println("Please make sure all ebooks are in the Ebooks folder");
		 System.out.println("Would you like to (1) See list of ebooks or (2) copy all ebooks into a .zip?");
		 
		 //Get User Input (uI) for the first question
		 uI = scanner.nextInt();
		 
		 
         while (uI != 1  && uI != 2) {
        	 
        	 System.out.println("You have entered a number that is not one of the options. Please try again: ");
        	 uI = scanner.nextInt();
        	 
         }
         
         //First Questions
		 if (uI == 1) {
			 System.out.println("Are all of your Ebooks in the standard .epub (1) or also in other file types? (2) ");
			 uI = scanner.nextInt();
			 if (uI == 1) { //Second Question
				 
			 } else if (uI == 2) { //Second Question, Second Answer
				 
				 System.out.println("Here is a list of Ebooks");
				 ListFiles.listFiles();
			 } //End of Second Question
			 
		 } else if (uI == 2) { //First Question, second answer
			ZipUtil.pack(new File("./Ebooks"), new File("./demo.zip"));

		 } //End of Second Question
		 
	     scanner.close(); 
	 } //End of public void main
} //End of Main Class

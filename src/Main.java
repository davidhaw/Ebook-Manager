import java.io.File;
import java.util.Scanner;

public class Main {

	 public static void main(String[] args) {
		
		 //The User Input Int. Should be able to be reused for every user input. 
		 int uI;
		 
		 Scanner scanner = new Scanner(System.in);
		 
		 //The first lines the User sees
		 System.out.println("Welcome to Ebook Manager");
		 System.out.println("Please make sure all ebooks are in the Ebooks folder");
		 System.out.println("Would you like to (1) See list of ebooks or (2) copy all ebooks into a .zip?");
		 
		 //Get User Input (uI) for the first question
		 uI = scanner.nextInt();
		 
		 if (uI == 1) {
			 System.out.println("Are all of your Ebooks in the standard .epub (1) or also in other file types?");
			 
			 System.out.println("Here is a list of Ebooks");
			 File folder = new File("./Ebooks");
			 File[] listOfFiles = folder.listFiles();

			 for (File file : listOfFiles) {
			     if (file.isFile()) {
			         System.out.println(file.getName());
			     }
			 }
		 }
		 
	     scanner.close(); 
	 }
}

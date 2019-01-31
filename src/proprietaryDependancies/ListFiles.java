package proprietaryDependancies;

import java.io.File;
import java.util.ArrayList;

public class ListFiles {

	public static File[] listFiles () {
		File folder = new File("./Ebooks");
		int x = 0;
		
		 File[] listOfFiles = folder.listFiles();

		 for (File file : listOfFiles) {
		     if (file.isFile()) {
		    	 x++;
		         System.out.println(x + ": " + file.getName());
		         
		     }
		 
		 }
		 return listOfFiles;
	}
	
	
	public static ArrayList<String> getEpubs(String directory) {
		  ArrayList<String> textFiles = new ArrayList<String>();
		  File dir = new File(directory);
		  for (File file : dir.listFiles()) {
		    if (file.getName().endsWith((".epub"))) {
		      textFiles.add(file.getName());
		    }
		  }
		  return textFiles;
		}

}
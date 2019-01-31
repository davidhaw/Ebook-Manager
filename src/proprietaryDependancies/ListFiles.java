package proprietaryDependancies;

import java.io.File;

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
	 
}

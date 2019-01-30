package proprietaryDependancies;

import java.io.File;

public class ListFiles {

	public static File[] listFiles () {
		File folder = new File("./Ebooks");

		 File[] listOfFiles = folder.listFiles();

		 for (File file : listOfFiles) {
		     if (file.isFile()) {
		         System.out.println(file.getName());
		         
		     }
		 
		 }
		 return listOfFiles;
	}
	 
}

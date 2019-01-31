package proprietaryDependancies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import nl.siegmann.epublib.domain.Author;
import nl.siegmann.epublib.domain.Book;
import nl.siegmann.epublib.epub.EpubReader;

public class ShowInfo {

	public static ArrayList<String> AllInfo (String pathRe) throws FileNotFoundException, IOException {
		ArrayList<String> info = new ArrayList<String>();
		
		EpubReader epubReader = new EpubReader();
		 Book book = epubReader.readEpub(new FileInputStream("." + pathRe));
		 List<Author> authours = book.getMetadata().getAuthors();

		 //Convert the List Object(authours) into a string list so we can ad it into the info string list
		 List<String> strings = new ArrayList<>(authours.size());
		 for (Object object : authours) {
		     strings.add(Objects.toString(object, null));
		 }

		 //Get Book language
	     String language = book.getMetadata().getLanguage(); 

	     //Add all the info into the array list
	     for(int i = 0; i < strings.size(); i++) {
	    	 info.add(strings.get(i));
	     }
	     
	     info.add(language);

		 return info; 
		
		
		
	}
	
}

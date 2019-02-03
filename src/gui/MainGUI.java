package gui;

import javafx.scene.control.Label;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.zeroturnaround.zip.ZipUtil;

//import org.zeroturnaround.zip.ZipUtil;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import proprietaryDependancies.ListFiles;
import proprietaryDependancies.ShowInfo;

@SuppressWarnings("restriction")
public class MainGUI extends Application {
   
    
    @Override
    public void start(Stage primaryStage) {
    	
    	//Label to show ebook directory. DELETE LATER
    	final Label labelSelectedDirectory = new Label();
    	labelSelectedDirectory.setText("C:");
    	
    	final Label bookInfo = new Label();
    	labelSelectedDirectory.setText("Book Info Will Be Here");
    	
        ArrayList<String>[] al = new ArrayList[1]; 
        al[0] = new ArrayList<String>(); 

    	final ArrayList<String> files;
        ListView<String> listView = new ListView<String>();

    	
    	//Create the Menu Bar
    	Menu directoryMenu = new Menu("Directory");

    	MenuBar menuBar = new MenuBar();

    	menuBar.getMenus().add(directoryMenu);
    	
    	//Create Select Ebook Folder in Menu Bar
    	MenuItem openFolder = new MenuItem("Select Ebook Folder");
    	openFolder.setOnAction(e -> {
    		DirectoryChooser directoryChooser = new DirectoryChooser();
    		File selectedDirectory = directoryChooser.showDialog(primaryStage);
    		if(selectedDirectory == null) {
    			labelSelectedDirectory.setText("No Directory Selected");
    		} else {
    			System.out.println(selectedDirectory.getAbsolutePath());
    	    	labelSelectedDirectory.setText(selectedDirectory.getAbsolutePath());
    	    	
    	        //Relist all the epubs into the list
    			listView.getItems().clear();
    			al[0] = ListFiles.getEpubs(labelSelectedDirectory.getText());
    	        for(int i = 0; i < al[0].size(); i++) { 
    				 listView.getItems().add((al[0].get(i)));
    			 }

    		}
    	});
    	
    	//Create ZipFolder button in the menu bar
    	MenuItem zipFolder = new MenuItem("Zip Ebook Folder");
    	zipFolder.setOnAction(e -> {
			ZipUtil.pack(new File(labelSelectedDirectory.getText()), new File("./Ebooks.zip"));
			System.out.println("Ebook Folder has been Exported to Ebooks.zip");
    	});

    	directoryMenu.getItems().add(openFolder);
    	directoryMenu.getItems().add(zipFolder);
    	
    	
    	
        //List all the epubs into the list
		al[0] = ListFiles.getEpubs(labelSelectedDirectory.getText());
        for(int i = 0; i < al[0].size(); i++) { 
			 listView.getItems().add((al[0].get(i)));
		 }

        //Make a button to print out info about selected epub
        Button buttonList = new Button("Get Epub Info");

        buttonList.setOnAction(event -> {
            ObservableList selectedIndices = listView.getSelectionModel().getSelectedIndices();

            for(Object o : selectedIndices){
                System.out.println("o = " + o);
                int i = (int) o;
                ArrayList<String> info;
				try {

					info = ShowInfo.AllInfo(labelSelectedDirectory.getText() + "/" + al[0].get(i));
					bookInfo.setText("Author: " + info.get(0) + "\n" + 
					"Language: " + info.get(1) + "\n" + 
					"Title: " + info.get(2));
					System.out.println("Author: " + info.get(0)); 
					System.out.println("Language: " + info.get(1)); 
					System.out.println("Title: " + info.get(2));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
            }
        });
				

    	//Get Ebook Folder Button
 /*   	Button btnOpenDirectoryChooser = new Button();
    	btnOpenDirectoryChooser.setText("Open DirectoryChooser");
    	btnOpenDirectoryChooser.setOnAction(new EventHandler<ActionEvent>() {
    	public void handle(ActionEvent event) {
    		
    		DirectoryChooser directoryChooser = new DirectoryChooser();
    		File selectedDirectory = directoryChooser.showDialog(primaryStage);
    		if(selectedDirectory == null) {
    			labelSelectedDirectory.setText("No Directory Selected");
    		} else {
    			System.out.println(selectedDirectory.getAbsolutePath());
    	    	labelSelectedDirectory.setText(selectedDirectory.getAbsolutePath());
    	    	
    	        //Relist all the epubs into the list
    			listView.getItems().clear();
    			al[0] = ListFiles.getEpubs(labelSelectedDirectory.getText());
    	        for(int i = 0; i < al[0].size(); i++) { 
    				 listView.getItems().add((al[0].get(i)));
    			 }

    		}
    	}
    	
    	
       	});
   */ 	
    	VBox vBox = new VBox();
    	vBox.getChildren().addAll(
    			menuBar,
    			listView,
    			buttonList,
    			bookInfo,
    			labelSelectedDirectory);
  
    	StackPane root = new StackPane();
    	root.getChildren().add(vBox);
    	Scene scene = new Scene(root, 500, 450);

    	primaryStage.setTitle("Ebook Manager");
    	primaryStage.setScene(scene);
    	primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

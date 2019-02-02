package gui;

import javafx.scene.control.Label;
import java.io.File;

import org.zeroturnaround.zip.ZipUtil;

//import org.zeroturnaround.zip.ZipUtil;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class MainGUI extends Application {
   
    
    @Override
    public void start(Stage primaryStage) {

    	//Label to show ebook directory. DELETE LATER
    	final Label labelSelectedDirectory = new Label();
    	labelSelectedDirectory.setText("./Ebooks");
    	
    	//Zip Ebook folder into ebooks.zip
    	Button zipFolder = new Button();
    	zipFolder.setText("Zip Ebooks Folder into ebooks.zip");
    	zipFolder.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Put zip code in her that zips to user chosen directory
				ZipUtil.pack(new File(labelSelectedDirectory.getText()), new File("./Ebooks.zip"));
				System.out.println("Ebook Folder has been Exported to Ebooks.zip");
				
			}
    		
    		
    		
    	});
    	
    	//Get Ebook Folder Button
    	Button btnOpenDirectoryChooser = new Button();
    	btnOpenDirectoryChooser.setText("Open DirectoryChooser");
    	btnOpenDirectoryChooser.setOnAction(new EventHandler<ActionEvent>() {
    	public void handle(ActionEvent event) {
    		
    		DirectoryChooser directoryChooser = new DirectoryChooser();
    		File selectedDirectory = directoryChooser.showDialog(primaryStage);
    		if(selectedDirectory == null) {
    			labelSelectedDirectory.setText("No Directory Selected");
    		} else {
    	    	labelSelectedDirectory.setText(selectedDirectory.getAbsolutePath());
    		}
    	}
    	
    	
       	});
    	
    	VBox vBox = new VBox();
    	vBox.getChildren().addAll(
    			btnOpenDirectoryChooser,
    			zipFolder,
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

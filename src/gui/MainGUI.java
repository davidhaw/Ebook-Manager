package gui;
import java.io.File;

import org.zeroturnaround.zip.ZipUtil;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
@SuppressWarnings("restriction")
public class MainGUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ebook Manager");
        Button btn = new Button();
        btn.setText("Compress Ebook Folder Into ZIP");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
    			ZipUtil.pack(new File("./Ebooks"), new File("./demo.zip"));
    			System.out.println("Ebook Folder has been Exported to Ebooks.zip");            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 500, 450));
        primaryStage.show();
    }
}

package fi.utu.tech.gui.javafx;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import fi.utu.tech.gui.javafx.teht5.*;

public class MainApp5 extends MainApp{

	
    public void start(Stage stage) throws Exception {
        System.out.println("Stage C");
        ResourceLoader<Parent, FXMLController> loader = new ResourceLoader<>("scene.fxml");
        loader.controller.setLabel("Welcome!");

        // configure the menu to create windows with createWindow
        loader.controller.setWindowFactory(this::createWindow);
        
        MyScene myScene = new MyScene();

        Scene scene = new Scene(myScene);
        scene.getStylesheets().add(createStyle());
        
        stage.setTitle("JavaFX template");
        stage.setScene(scene);
        stage.show();
        System.out.println("Stage D");
    }
}

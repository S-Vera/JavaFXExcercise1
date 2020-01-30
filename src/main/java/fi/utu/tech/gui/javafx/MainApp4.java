package fi.utu.tech.gui.javafx;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp4 extends MainApp{

    protected Parent createWindow() {
        return new fi.utu.tech.gui.javafx.teht4.OtherWindow();
    }
    
    protected String createStyle() {
        return ResourceLoader.stylesheet("styles2.css");
    }
	
    public void start(Stage stage) throws Exception {
        System.out.println("Stage C");
        ResourceLoader<Parent, FXMLController> loader = new ResourceLoader<>("scene.fxml");
        loader.controller.setLabel("Welcome!");

        // configure the menu to create windows with createWindow
        loader.controller.setWindowFactory(this::createWindow);

        Scene scene = new Scene(loader.root);
        scene.getStylesheets().add(createStyle());
        
        stage.setTitle("JavaFX template");
        stage.setScene(scene);
        stage.show();
        System.out.println("Stage D");
    }
}

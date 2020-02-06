package fi.utu.tech.gui.javafx.teht5;


import fi.utu.tech.gui.javafx.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MyScene extends BorderPane{
	
	public MyScene() {
		
		setPrefHeight(400.0);
		setPrefWidth(600.0);
		
		Insets is = new Insets(16.0);
		setMargin(this, is);
		setPadding(is);
		
		Button button1 = new Button("Open a new window");
		Button button2 = new Button("Display a dialog");
		Button button3 = new Button("Exit");
		button1.setMaxWidth(1.7976931348623157E308);
		button2.setMaxWidth(1.7976931348623157E308);
		button3.setMaxWidth(1.7976931348623157E308);
		
		Label label = new Label("What should we do?");
		setAlignment(label, Pos.CENTER);
		label.setFont(new Font(26));
		setTop(label);
		
		Label clicklabel = new Label("Loading");
		
		VBox vbox = new VBox(16.0);
		vbox.getChildren().addAll(button1, button2, button3);
		vbox.setAlignment(Pos.CENTER);
		vbox.setPrefSize(100.0, 200.0);
		setCenter(vbox);
		

		
		
		ImageView kuva = new ImageView(ResourceLoader.image("hmm.png"));
		kuva.setFitHeight(368.0);
		kuva.setFitWidth(200.0);
		kuva.setPreserveRatio(true);
		kuva.setPickOnBounds(true);
		setLeft(kuva);
		
		//button1.setOnAction(new EventHandler<ActionEvent>());
			
		}
		
    private Label clicksLabel;
    private IntegerProperty clicks = new SimpleIntegerProperty(0);

    protected void updateClicks() {
        if (!clicksLabel.textProperty().isBound())
            clicksLabel.textProperty().bind(clicks.asString().concat(" clicks."));

        clicks.setValue(clicks.getValue() + 1);
    }
	
	
	public void openWindow(ActionEvent event) {
		//tehtävä 7
		Parent root;
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("otherwindow.fxml"));
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}

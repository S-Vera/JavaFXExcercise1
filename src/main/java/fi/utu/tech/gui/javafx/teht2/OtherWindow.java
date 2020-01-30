package fi.utu.tech.gui.javafx.teht2;

import fi.utu.tech.gui.javafx.*;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;


public class OtherWindow extends BorderPane {
    public OtherWindow() {
        Circle c = new Circle(200, Color.NAVY);
        setCenter(c);
        setLeft(new ImageView(ResourceLoader.image("hmm.png")));
        
        Label label = new Label("Terve");

        setTop(label);
        setAlignment(label, Pos.TOP_CENTER);
        
        Text text = new Text("Maailma");
        StackPane stack = new StackPane();
        stack.getChildren().addAll(c, text);
        setCenter(stack);
        
        
    }
}

package fi.utu.tech.gui.javafx.teht4;

import javafx.scene.control.TextField;

import javafx.scene.layout.VBox;
import fi.utu.tech.gui.javafx.*;
import javafx.css.PseudoClass;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
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

        
        TextField textfield1 = new TextField();
        TextField textfield2 = new TextField();
        TextField textfield3 = new TextField();
        GridPane grid = new GridPane();
        GridPane.setColumnIndex(textfield1, 0);
        GridPane.setColumnIndex(textfield2, 1);
        GridPane.setColumnIndex(textfield3, 2);
        grid.getChildren().addAll(textfield1, textfield2, textfield3);
        
        
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(50);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(50);
        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(50);
        grid.getColumnConstraints().addAll(column1, column2, column3);
        grid.setPrefWidth(200);
        
        VBox vbox = new VBox(stack, grid);
        setCenter(vbox);
        
        vbox.getStyleClass().add("1");
        grid.getStyleClass().add("2");
        stack.getStyleClass().add("3");
        label.getStyleClass().add("4");
        getStyleClass().add("5");
        setId("muokkaus");
        
        
    }
}

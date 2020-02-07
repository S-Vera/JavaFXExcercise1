package fi.utu.tech.gui.javafx.teht5_A1_A2;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ExcRectangle extends BorderPane{
	
	public ExcRectangle() {
		StackPane s1 = new StackPane();
		StackPane s2 = new StackPane();
		Rectangle nelio = new Rectangle(300, 300, Color.HOTPINK);
		
		s2.getChildren().add(nelio);
		s1.getChildren().add(s2);
		
		setTop(s1);
		
		nelio.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				MouseEvent.fireEvent(s2, e);
				System.out.println(toString());
				e.consume();
				
			}
		});
		
		s1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				System.out.println(toString());
				
			}
		});
		
		s2.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override public void handle(MouseEvent e) {
				System.out.println(toString());
			}
		});
		

		
	}

}

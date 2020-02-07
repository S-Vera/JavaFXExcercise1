package fi.utu.tech.gui.javafx.teht4_A1_A2;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class Selain extends BorderPane{

	
	public Selain() {
		
		TextField url = new TextField();
		WebView webView = new WebView();
		
		WebEngine webEngine = webView.getEngine();

		url.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override public void handle(KeyEvent e) {
				if (e.getCode().equals(KeyCode.ENTER)) {
					webEngine.load(url.getText());
					System.out.println(url.getText());
				}
			}
		});

		setTop(url);
		setBottom(webView);
		
	}
}

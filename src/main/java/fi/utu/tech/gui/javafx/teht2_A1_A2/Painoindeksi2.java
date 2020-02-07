package fi.utu.tech.gui.javafx.teht2_A1_A2;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.NumberStringConverter;

public class Painoindeksi2 extends BorderPane{
	
	public Painoindeksi2() {
		TextField paino = new TextField();
		TextField pituus = new TextField();
		Label bmi = new Label("joo");
		Label pal = new Label("Paino");
		Label pil = new Label("Pituus");
		Label virhe = new Label();
		VBox vbox1 = new VBox();
		VBox vbox2 = new VBox();
		HBox hbox = new HBox();
		DoubleProperty num1 = new SimpleDoubleProperty();
		DoubleProperty num2 = new SimpleDoubleProperty();
		
		
		paino.textProperty().addListener(new ChangeListener<String>(){
			@Override public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				
				try {
					num1.set(new SimpleDoubleProperty(Double.parseDouble(paino.toString())).getValue());
				}
				catch (Exception e) {
					
				}
				if (!newValue.matches("\\d*")) {
					System.out.println("virhe");
					paino.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});
		pituus.textProperty().addListener(new ChangeListener<String>(){
			@Override public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				
				try {
					num2.set(new SimpleDoubleProperty(Double.parseDouble(pituus.toString())).getValue());
				}
				catch(Exception e) {
					
				}
				if (!newValue.matches("\\d*")) {
					System.out.println("virhe");
					paino.setText(newValue.replaceAll("[^\\d]", ""));
				}
			}
		});

		try {
			
			
			
		}
		
		catch (Exception e) {
			
		}
	
		DoubleProperty num3 = new SimpleDoubleProperty();
		NumberStringConverter converter = new NumberStringConverter();
			
		paino.textProperty().bindBidirectional(num1, converter);
		pituus.textProperty().bindBidirectional(num2, converter);

			
		
		NumberBinding tulos = num1.divide(num2.multiply(num2));
		bmi.setText("BMI="+num1.divide(num2));
		
		
		

		vbox1.getChildren().addAll(pal,paino);
		vbox2.getChildren().addAll(pil,pituus);
		vbox1.setSpacing(10);
		vbox2.setSpacing(10);
		
		
		
		
		hbox.getChildren().addAll(vbox1,vbox2,bmi,virhe);
		hbox.setPadding(new Insets(20));
		//setTop(virhe);
		setTop(hbox);

		
	}
	

}

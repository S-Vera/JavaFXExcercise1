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

public class Painoindeksi extends BorderPane{
	
	public Painoindeksi() {
		TextField paino = new TextField();
		TextField pituus = new TextField();
		Label bmi = new Label();
		Label pal = new Label("Paino");
		Label pil = new Label("Pituus");
		Label virhe = new Label();
		
		VBox vbox1 = new VBox();
		VBox vbox2 = new VBox();
		HBox hbox = new HBox();
		

		
		
		//paino.setTextFormatter(new TextFormatter<Double>(formatter));
		//pituus.setTextFormatter(new TextFormatter<Double>(formatter));
		
		DoubleProperty num1 = new SimpleDoubleProperty();
		DoubleProperty num2 = new SimpleDoubleProperty();
		//DoubleProperty num3 = new SimpleDoubleProperty(Double.parseDouble(paino.getText()));
		//DoubleProperty num4 = new SimpleDoubleProperty(Math.pow(Double.parseDouble(pituus.getText()),2));
		DoubleProperty nbmi = new SimpleDoubleProperty();
		
		nbmi.bind(num1.divide(num2.multiply(num2)));
		NumberStringConverter converter = new NumberStringConverter();
		Bindings.bindBidirectional(paino.textProperty(), num1, (StringConverter<Number>)converter);
		Bindings.bindBidirectional(pituus.textProperty(), num2, (StringConverter<Number>)converter);
		Bindings.bindBidirectional(bmi.textProperty(), nbmi, (StringConverter<Number>)converter);
	
		
		num2.addListener(new ChangeListener<Number>() {
			@Override public void changed(ObservableValue<? extends Number> o,Number oldValue, Number newValue) {
				if (num2.getValue() == 0.0) {
					virhe.setText("virhe");
					System.out.println("virhe");
					
				}
				else {
					virhe.setText("");
				}
			}
		});
		
		
		//bmi.setText("BMI="+nbmi.get());

		vbox1.getChildren().addAll(pal,paino);
		vbox2.getChildren().addAll(pil,pituus);
		vbox1.setSpacing(10);
		vbox2.setSpacing(10);
		
		
		hbox.getChildren().addAll(vbox1,vbox2,bmi);
		hbox.setPadding(new Insets(20));
		setTop(virhe);
		setTop(hbox);

		
	}
	

}

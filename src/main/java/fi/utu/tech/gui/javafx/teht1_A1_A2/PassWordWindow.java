package fi.utu.tech.gui.javafx.teht1_A1_A2;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

import fi.utu.tech.gui.javafx.*;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;

public class PassWordWindow extends BorderPane{
	
	public PassWordWindow() {
		
		Label tieto = new Label();
		
		Button button1 = new Button("Tyhjennä");
		Button button2 = new Button("Hyväksy salasana");
		
		PasswordField pass = new PasswordField();
		pass.setPromptText("Syötä salasan");
		

		button1.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e) {
				pass.clear();
			}
			
		});
		
		button2.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				String arvo = encryptPassword(pass.getText());
				Dialogs.warning("Salasanan SAI-arvo", "Salasanan SAI-Arvo", arvo);
			}
		});
		
		
		pass.textProperty().addListener(new ChangeListener<String>() {
			@Override public void changed(ObservableValue<? extends String> o,String oldValue, String newValue) {
				if (pass.getLength() < 8) {
					tieto.setText("Salasanan pitää olla vähintään 8 merkkiä pitkä");
				}
				else {
					tieto.setText("");
				}
			}
		});
		

		setTop(tieto);
		setCenter(button1);
		setLeft(button2);
		setRight(pass);
		
		

		
	}
	
	private static String encryptPassword(String password){
	    String sha1 = "";
	    try{
	        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
	        crypt.reset();
	        crypt.update(password.getBytes("UTF-8"));
	        sha1 = byteToHex(crypt.digest());
	    }
	    catch(NoSuchAlgorithmException e){
	        e.printStackTrace();
	    }
	    catch(UnsupportedEncodingException e)
	    {
	        e.printStackTrace();
	    }
	    return sha1;
	}
	
	private static String byteToHex(final byte[] hash)
	{
	    Formatter formatter = new Formatter();
	    for (byte b : hash)
	    {
	        formatter.format("%02x", b);
	    }
	    String result = formatter.toString();
	    formatter.close();
	    return result;
	}

}

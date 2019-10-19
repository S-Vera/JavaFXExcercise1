package fi.utu.tech.gui.javafx;

import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FXMLController {
    private IntegerProperty clicks = new SimpleIntegerProperty(0);

    @FXML
    private Label clicksLabel;

    void updateClicks() {
        if (!clicksLabel.textProperty().isBound())
            clicksLabel.textProperty().bind(clicks.asString().concat(" clicks."));

        clicks.setValue(clicks.getValue() + 1);
    }

    void setLabel(String text) {
        if (!clicksLabel.textProperty().isBound())
            clicksLabel.setText(text);
    }

    @FXML
    void handleDialogButton(ActionEvent event) {
        updateClicks();
        Dialogs.warning("Example dialog", "Content header", "Content");
    }

    @FXML
    void handleExitButton(ActionEvent event) {
        System.out.println("Closing app.");
        Platform.exit();
    }

    @FXML
    void handleWindowButton(ActionEvent event) {
        updateClicks();
        Scene other = new Scene(new OtherWindow());
        Stage otherStage = new Stage();
        otherStage.setScene(other);
        otherStage.show();
    }

    public void initialize() {
        System.out.println("2-A");
    }
}

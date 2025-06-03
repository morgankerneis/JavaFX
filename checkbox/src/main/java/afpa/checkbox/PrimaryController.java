package afpa.checkbox;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

public class PrimaryController {
    @FXML
    private Label editableLabel;

    @FXML
    public void updateLabel(KeyEvent event) {
        System.out.println(editableLabel);
    }
}

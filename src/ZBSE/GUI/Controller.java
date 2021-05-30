package ZBSE.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

public class Controller {

    @FXML
    Label label;

    public void test (ActionEvent e) {
        System.out.println("test");
    }

    public void SaveSelect(ActionEvent e) {
        System.out.println(((MenuItem)e.getSource()).getUserData());
    }
}

package ZBSE.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    Label label;
    @FXML
    TextField ZBDir;

    public void test (ActionEvent e) {
        System.out.println("test");
        System.out.println(e);
    }

    public void SaveSelect(ActionEvent e) {
        String saveNum = (String)((MenuItem)e.getSource()).getUserData();
        GUI.setSave(saveNum, ZBDir.getText());
    }
}

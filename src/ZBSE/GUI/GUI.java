package ZBSE.GUI;

import ZBSE.ZBSave;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GUI extends Application {

    protected ZBSave currentSave;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        // basic setup stuff
        Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml")); // the fxml it loads from
        Scene scene = new Scene(root);
        primaryStage.setTitle("ZBSE"); // the title at the top of the window
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

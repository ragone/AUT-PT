package aut;

import aut.controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view/main.fxml"));
            root = fxmlLoader.load();
            MainController controller = fxmlLoader.<MainController>getController();
            Stage stage = new Stage();
            controller.setStage(stage);
            stage.getIcons().addAll(new Image("file:images/icon16.png"),
                    new Image("file:images/icon16.png"),
                    new Image("file:images/icon64.png"),
                    new Image("file:images/icon128.png"));
            stage.setTitle("AUT Sport + Fitness Centres");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {

        launch(args);
    }
}

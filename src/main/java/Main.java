import aut.controller.HibernateUtil;
import aut.model.Member;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/main.fxml"));
            root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.getIcons().addAll(new Image("images/icon16.png"),
                    new Image("images/icon16.png"),
                    new Image("images/icon64.png"),
                    new Image("images/icon128.png"));
            stage.setTitle("AUT Sport + Fitness Centres");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        session.save(new Member("Alex", "Ragone"));

        session.getTransaction().commit();

        launch(args);
    }
}

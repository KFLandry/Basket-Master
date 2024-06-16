package main.assocationbasketproject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class Main extends  Application{
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),830,750);
        stage.setScene(scene);
        stage.setTitle("Association basket App");
        stage.setResizable(false);
        stage.show();
    }
    public static void main(String[] args) throws Exception {
      launch();
    }
}
package SRC.View;

import SRC.Model.VO.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application {
    private static Stage primaryStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void setPrimaryStage(Stage primaryStage) {
        Telas.primaryStage = primaryStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        setPrimaryStage(primaryStage);
        primaryStage.setTitle("I read");
        primaryStage.show();
        telaLogin();
    }

    public static void telaLogin() throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/Login.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
    }

    public static void telaInicial() throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/Home.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
    }

    public static void main(String ... args) {
        launch();
    }
}

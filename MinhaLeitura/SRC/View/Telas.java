package SRC.View;

import SRC.Model.VO.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileInputStream;

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

    public static void telaLeituras() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/EmLeitura.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
    }

    public static void telaLeiturasFinalizadas() throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/Finalizadas.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
    }

    public static void telaConfiguracoes() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/Configuracoes.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
    }

    public static void modalAddLeitura() throws Exception{
        Stage newStage = new Stage();
        //newStage.initStyle(StageStyle.TRANSPARENT);
        newStage.setTitle("Nova Leitura");

        newStage.initOwner(Telas.primaryStage);
        newStage.initModality(Modality.APPLICATION_MODAL);

        Parent root = FXMLLoader.load(Telas.class.getResource("VE/modalAddLeitura.fxml"));
        Scene cena = new Scene(root);
        newStage.setScene(cena);
        newStage.show();
    }

    public static void main(String ... args) {
        launch();
    }
}

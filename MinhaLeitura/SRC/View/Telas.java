package SRC.View;

import SRC.Controller.HomeController;
import SRC.Controller.ModalLeituraController;
import SRC.Model.VO.Book;
import SRC.Model.VO.User;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.*;

import java.io.File;
import java.io.FileInputStream;

public class Telas extends Application {
    private static Stage primaryStage;
    private static  Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();

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
        primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);
    }

    public static void telaCadastro() throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/Cadastro.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);
    }

    public static void telaInicial(User usuario) throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/Home.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);
    }

    public static void telaLeituras() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/EmLeitura.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);
    }

    public static void telaLeiturasFinalizadas() throws Exception {
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/Finalizadas.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);
    }

    public static void telaConfiguracoes() throws Exception{
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/Configuracoes.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);
    }

    static Stage newStage = new Stage();

    public static void Informativo() throws Exception{
        newStage.initStyle(StageStyle.TRANSPARENT);
        newStage.initOwner(Telas.primaryStage);
        newStage.initModality(Modality.APPLICATION_MODAL);

        Parent root = FXMLLoader.load(Telas.class.getResource("VE/Informativo.fxml"));
        Scene cena = new Scene(root);
        newStage.setScene(cena);
        newStage.show();
        newStage.setX((primScreenBounds.getWidth() - newStage.getWidth()) / 2);
        newStage.setY((primScreenBounds.getHeight() - newStage.getHeight()) / 2);
    }

    public static void modalPesquisaLeitura() throws Exception{
        //newStage.initStyle(StageStyle.TRANSPARENT);
        newStage.setTitle("Adicionando uma nova leitura");

        //newStage.initOwner(Telas.primaryStage);
        //newStage.initModality(Modality.APPLICATION_MODAL);

        Parent root = FXMLLoader.load(Telas.class.getResource("VE/modalPesquisaLeitura.fxml"));
        Scene cena = new Scene(root);
        newStage.setScene(cena);
        newStage.show();
        newStage.setX((primScreenBounds.getWidth() - newStage.getWidth()) / 2);
        newStage.setY((primScreenBounds.getHeight() - newStage.getHeight()) / 2);
    }

    public static void modalAddLeitura() throws Exception{
        //newStage.initStyle(StageStyle.TRANSPARENT);
        Parent root = FXMLLoader.load(Telas.class.getResource("VE/modalAddLeitura.fxml"));
        Scene cena = new Scene(root);
        newStage.setScene(cena);
        newStage.show();
        newStage.setX((primScreenBounds.getWidth() - newStage.getWidth()) / 2);
        newStage.setY((primScreenBounds.getHeight() - newStage.getHeight()) / 2);
    }

    public static void modalLeitura(Book livro) throws Exception{
        ModalLeituraController.livro = livro;
        Stage newStage = new Stage();
        //newStage.initStyle(StageStyle.TRANSPARENT);
        newStage.setTitle("Minha leitura atual");

        newStage.initOwner(Telas.primaryStage);
        newStage.initModality(Modality.APPLICATION_MODAL);

        Parent root = FXMLLoader.load(Telas.class.getResource("VE/modalLeitura.fxml"));
        Scene cena = new Scene(root);
        newStage.setScene(cena);
        newStage.show();
        newStage.setX((primScreenBounds.getWidth() - newStage.getWidth()) / 2);
        newStage.setY((primScreenBounds.getHeight() - newStage.getHeight()) / 2);
    }

    public static void main(String ... args) {
        launch();
    }
}

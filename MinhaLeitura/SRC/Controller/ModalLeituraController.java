package SRC.Controller;

import SRC.Model.VO.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ModalLeituraController implements Initializable {
    public static Book livro;

    @FXML public TextField titulo;
    @FXML public TextField autor;
    @FXML public TextField descricao;
    @FXML public SplitMenuButton genero;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        titulo.setText(livro.getTitle());
        autor.setText(livro.getAuthor());
        descricao.setText("Aqui vai a descrição do livro");
        genero.setText(livro.getCategory());
    }

    @FXML
    private Button fecharTela;
    public void fecharModalLeitura(ActionEvent event) throws Exception{
        Stage stage = (Stage) fecharTela.getScene().getWindow(); //Obtendo a janela atual
        stage.close(); //Fechando o Stage
    }
}

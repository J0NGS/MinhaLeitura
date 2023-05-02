package SRC.Controller;

import SRC.Model.VO.Book;
import SRC.Model.VO.User;
import SRC.View.Telas;
import Utils.InterfaceNewComponents.HBoxBook;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EmLeituraController implements Initializable {

    private User usuario;
    @FXML
    public Label nomeUsuario;

    @FXML public ListView<HBoxBook> minhasLeituras;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       nomeUsuario.setText(usuario.getUsername());
        try {
            leiturasAtuais();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public EmLeituraController() {
        usuario = FrontController.getUsuario();
    }

    public void sair(ActionEvent event) throws Exception{
        Telas.telaLogin();
    }

    public void telaInicial(ActionEvent event) throws  Exception{
        Telas.telaInicial(usuario);
    }

    public void telaLeituras(ActionEvent event) throws  Exception{
        Telas.telaLeituras();
    }

    public void telaLeiturasFinalizadas(ActionEvent event) throws  Exception{
        Telas.telaLeiturasFinalizadas();
    }

    public void telaConfiguracoes(ActionEvent event) throws  Exception{
        Telas.telaConfiguracoes();
    }

    public void abrirModalAddLeitura(ActionEvent event) throws  Exception{
        Telas.modalAddLeitura();
    }

    public void leiturasAtuais() throws Exception{
        Book livro = new Book("Corte de espinhos e rosas", "Sarah J. Mass", "Galera", LocalDate.of(2021, 9, 21), "Fantasy");
        List<HBoxBook> livros = new ArrayList<>();
        ObservableList<HBoxBook> observableBook;
        livros.add(new HBoxBook(livro));
        livro = new Book("Corte de asas e ruinas", "Sarah J. Mass", "Galera", LocalDate.of(2021, 9, 21), "Fantasy");
        livros.add(new HBoxBook(livro));

        observableBook = FXCollections.observableArrayList(livros);

        minhasLeituras.setItems(observableBook);
        minhasLeituras.getSelectionModel().selectedItemProperty().addListener(this::abrirModalLeitura);
    }

    private void abrirModalLeitura(ObservableValue<? extends HBoxBook> observable, HBoxBook livroAntigo, HBoxBook livroNovo){
        HBoxBook livroSelecionado = minhasLeituras.getSelectionModel().getSelectedItem();

        try {
            Telas.modalLeitura(livroSelecionado.getLivro());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

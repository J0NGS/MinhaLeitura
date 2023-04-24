package SRC.Controller;

import SRC.Model.VO.Book;
import SRC.Model.VO.User;
import SRC.View.Telas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    private User usuario;
    @FXML public Label nomeUsuario;
    @FXML public ListView<Book> minhasLeiturasAtuais;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            nomeUsuario.setText(usuario.getUsername());
            Book livro = new Book(1l, "Corte de espinhos e rosas", "Sarah J. Mass", "Galera", LocalDate.of(2021, 9, 21), "Fantasy");
            List<Book> livros = new ArrayList<>();
            ObservableList<Book> observableBook;
            livros.add(livro);

            observableBook = FXCollections.observableArrayList(livros);

            minhasLeiturasAtuais.setItems(observableBook);
            leiturasAtuais();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public HomeController() {
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

    public void leiturasAtuais() throws Exception{
        System.out.println("Aqui é onde vai adicionar as leituras");
    }

    public void abrirModalAddLeitura(ActionEvent event) throws  Exception{
        Telas.modalAddLeitura();
    }
}

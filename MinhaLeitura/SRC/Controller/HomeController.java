package SRC.Controller;

import SRC.Model.BO.UserBO;
import SRC.Model.VO.Book;
import SRC.Model.VO.User;
import SRC.View.Telas;
import Utils.ED.LinkedList;
import Utils.ED.LinkedListDouble;
import Utils.InterfaceNewComponents.VBoxBook;
import Utils.InterfaceNewComponents.VBoxReadBook;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    private User usuario;
    private UserBO bo = new UserBO();

    @FXML public Label nomeUsuario;
    @FXML public Label email;
    @FXML public ListView<VBoxBook> minhasLeiturasAtuais;
    @FXML public ListView<VBoxReadBook> leiturasFinalizadas;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            nomeUsuario.setText(usuario.getName());
            email.setText(usuario.getEmail());
            leiturasAtuais();
            leiturasConcluidas();
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
        LinkedListDouble<Book> listaDeLivros = bo.listUserBookRead(usuario.getId());

        List<VBoxBook> livros = new ArrayList<>();
        ObservableList<VBoxBook> observableBook;

        for(int i = 0; i < listaDeLivros.getSize(); i++){
            livros.add((new VBoxBook(listaDeLivros.peekFirst())));
        }

        observableBook = FXCollections.observableArrayList(livros);

        minhasLeiturasAtuais.setItems(observableBook);
        minhasLeiturasAtuais.getSelectionModel().selectedItemProperty().addListener(this::abrirModalLeitura);
    }

    public void leiturasConcluidas() throws Exception {
        Book livro = new Book("Corte de espinhos e rosas", "Sarah J. Mass", "Galera", LocalDate.of(2021, 9, 21), "Fantasy");
        List<VBoxReadBook> livros = new ArrayList<>();
        ObservableList<VBoxReadBook> observableBook;
        livros.add(new VBoxReadBook(livro));
        livro = new Book("Corte de asas e ruinas", "Sarah J. Mass", "Galera", LocalDate.of(2021, 9, 21), "Fantasy");
        livros.add(new VBoxReadBook(livro));

        observableBook = FXCollections.observableArrayList(livros);
        leiturasFinalizadas.setItems(observableBook);
        //leiturasFinalizadas.getSelectionModel().selectedItemProperty().addListener(this::abrirModalLeitura);
    }

    public void abrirModalAddLeitura(ActionEvent event) throws  Exception{
        Telas.modalPesquisaLeitura();
    }

    private void abrirModalLeitura(ObservableValue<? extends VBoxBook> observable, VBoxBook livroAntigo, VBoxBook livroNovo){
        VBoxBook livroSelecionado = minhasLeiturasAtuais.getSelectionModel().getSelectedItem();

        try {
            Telas.modalLeitura(livroSelecionado.getLivro());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

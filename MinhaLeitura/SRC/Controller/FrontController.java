package SRC.Controller;

import SRC.Model.BO.BookBO;
import SRC.Model.BO.UserBO;
import SRC.Model.DAO.UserDAO;
import SRC.Model.VO.Book;
import SRC.Model.VO.User;
import SRC.View.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.awt.event.KeyEvent;
import java.time.LocalDate;

public class FrontController {
    @FXML private Label avisoLogin;
    @FXML private TextField username;
    @FXML private PasswordField password;


    private static User usuario;
    UserBO userBO = new UserBO();
    UserDAO userDAO = new UserDAO();

    public static User getUsuario() {
        return usuario;
    }

    private UserDAO usuarioDAO = new UserDAO();

    public void autenticar(ActionEvent event) throws Exception{
        usuario = userBO.login(username.getText(), password.getText());
        if (usuario != null){
            Telas.telaInicial(usuario);
        }else{
            avisoLogin.setVisible(true);
        }
    }

    public void fazerCadastro(ActionEvent event) throws Exception{
        Telas.telaCadastro();
    }

    @FXML
    private Button fecharTela;
    public void fecharModalAddLeitura(ActionEvent event) throws Exception{
        Stage stage = (Stage) fecharTela.getScene().getWindow(); //Obtendo a janela atual
        stage.close(); //Fechando o Stage
    }

    public void cadastrarNovoLivro(ActionEvent event) throws Exception{
        Telas.modalAddLeitura();
    }

    BookBO bo = new BookBO();

    public void pesquisarLivro(ActionEvent event) throws Exception{

    }

    @FXML SplitMenuButton genero;
    @FXML TextField titulo;
    @FXML TextField autor;
    @FXML TextField editora;
    @FXML TextField descricao;
    @FXML DatePicker data;
    public void cadastrarLivro(ActionEvent event) throws Exception{
        Book livro = new Book(titulo.getText(),autor.getText(), editora.getText(), data.getValue(), genero.getText());
        bo.addBook(livro);
    }

    public void aventura(ActionEvent event) throws Exception{
        genero.setText("Aventura");
    }

    public void fantasia(ActionEvent event) throws Exception{
        genero.setText("Fantasia");
    }

    public void romance(ActionEvent event) throws Exception{
        genero.setText("Romance");
    }

    public void suspense(ActionEvent event) throws Exception{
        genero.setText("Seuspense");
    }

    public void fatosReais(ActionEvent event) throws Exception{
        genero.setText("Fatos Reais");
    }

    public void investigacao(ActionEvent event) throws Exception{
        genero.setText("Investicação");
    }
}

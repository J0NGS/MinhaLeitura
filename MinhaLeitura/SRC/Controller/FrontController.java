package SRC.Controller;

import SRC.Model.DAO.UserDAO;
import SRC.Model.VO.User;
import SRC.View.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.awt.event.KeyEvent;

public class FrontController {
    @FXML private Label avisoLogin;
    @FXML private TextField username;
    @FXML private PasswordField password;


    private static User usuario;

    public static User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = new User(usuario.getUsername(),usuario.getPassword(), usuario.getEmail(), usuario.getName());
    }

    private UserDAO usuarioDAO = new UserDAO();

    public void autenticar(ActionEvent event) throws Exception{
        if (username.getText().isEmpty() && password.getText().isEmpty()){
            avisoLogin.setVisible(true);
        }else{
            usuario = new User(1l, username.getText(), password.getText());
            Telas.telaInicial(usuario);
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
}

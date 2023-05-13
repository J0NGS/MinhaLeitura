package SRC.Controller;

import SRC.Model.BO.UserBO;
import SRC.Model.VO.User;
import SRC.View.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CadastroController implements Initializable {
    UserBO usuario = new UserBO();
    @FXML TextField nome;
    @FXML TextField username;
    @FXML TextField email;
    @FXML PasswordField senha;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void cadastrar(ActionEvent event) throws Exception{
        try {
            usuario.createUser(username.getText(), senha.getText(), email.getText(), nome.getText());
            Telas.telaInicial(null);
        } catch (Exception e) {
            System.out.println("Erro ao criar usuário: " + e.getMessage());
        }
    }
}

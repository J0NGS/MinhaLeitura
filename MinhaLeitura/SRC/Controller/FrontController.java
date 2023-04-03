package SRC.Controller;

import SRC.DAO.UserDAO;
import SRC.Model.VO.User;
import SRC.View.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class FrontController {
    @FXML private Label avisoLogin;
    @FXML private TextField username;
    @FXML private PasswordField password;

    private User usuario;
    private UserDAO usuarioDAO = new UserDAO();

    public void autenticar(ActionEvent event) throws Exception{
        Telas.telaInicial();
    }

    public void fazerCadastro(ActionEvent event) throws Exception{

    }
}

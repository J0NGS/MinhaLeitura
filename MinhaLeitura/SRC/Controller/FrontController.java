package SRC.Controller;

import SRC.DAO.UserDAO;
import SRC.Model.VO.User;
import SRC.View.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FrontController {
    @FXML private Label avisoLogin;
    @FXML private TextField username;
    @FXML private PasswordField password;


    private User usuario;
    private UserDAO usuarioDAO = new UserDAO();

    public void autenticar(ActionEvent event) throws Exception{
        //avisoLogin.setVisible(true);
        Telas.telaInicial();
    }

    public void fazerCadastro(ActionEvent event) throws Exception{

    }

    public void sair(ActionEvent event) throws Exception{
        Telas.telaLogin();
    }

    public void telaInicial(ActionEvent event) throws  Exception{
        Telas.telaInicial();
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

    @FXML
    private Button fecharTela;
    public void fecharModalAddLeitura(ActionEvent event) throws Exception{
        Stage stage = (Stage) fecharTela.getScene().getWindow(); //Obtendo a janela atual
        stage.close(); //Fechando o Stage
    }
}

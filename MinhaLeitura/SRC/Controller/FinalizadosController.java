package SRC.Controller;

import SRC.Model.VO.User;
import SRC.View.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class FinalizadosController implements Initializable {
    private User usuario;
    @FXML
    public Label nomeUsuario;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            nomeUsuario.setText(usuario.getUsername());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public FinalizadosController() {
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
}

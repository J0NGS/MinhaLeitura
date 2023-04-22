package SRC.Controller;

import SRC.Model.VO.User;
import SRC.View.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HomeController {
    private User usuario;
    @FXML public Label nomeUsuario;

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

    public void abrirModalAddLeitura(ActionEvent event) throws  Exception{
        nomeUsuario.setText(usuario.getUsername());
    }
}

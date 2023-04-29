package Utils.InterfaceNewComponents;

import SRC.Model.VO.Book;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class VBoxBook extends VBox {
    Label titulo = new Label();
    Label autor = new Label();
    Button concluir = new Button();
    Button excluir = new Button();
    HBox botoes = new HBox();

    Book livro;

    public VBoxBook(Book livro) {
        super();

        this.livro = livro;

        titulo.getStyleClass().add("tituloLivro");
        titulo.setMinWidth(150);
        titulo.setMaxWidth(150);
        autor.getStyleClass().add("autorLivro");
        concluir.getStyleClass().add("concluirRedondo");
        concluir.setMinWidth(24.0);
        excluir.getStyleClass().add("excluirRedondo");
        excluir.setMinWidth(24.0);

        titulo.setText(livro.getTitle());
        titulo.setTranslateY(30);
        autor.setText(livro.getAuthor());
        autor.setTranslateY(30);
        concluir.setText("");
        Tooltip concluirLeitura = new Tooltip("Concluir leitura");
        concluir.setTooltip(concluirLeitura);
        excluir.setText("");
        Tooltip excluirLeitura = new Tooltip("Excluir leitura");
        excluir.setTooltip(excluirLeitura);

        Label espaco = new Label();
        espaco.setText(" ");

        botoes.getChildren().addAll(espaco, concluir, excluir);
        botoes.setSpacing(10.0);
        botoes.setTranslateY(60);


        this.getStyleClass().add("container");
        this.setMinWidth(162.0);
        this.setMinHeight(215.0);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(titulo, autor, botoes);
    }

    public Book getLivro() {
        return livro;
    }
}

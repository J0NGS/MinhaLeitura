package Utils.InterfaceNewComponents;

import SRC.Model.VO.Book;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;

public class HBoxBook extends HBox {

    Label titulo = new Label();
    Label autor = new Label();
    ImageView imagemLivro = new ImageView();
    Button concluir = new Button();
    Button editar = new Button();
    Button excluir = new Button();
    VBox dadosLivro = new VBox();
    VBox botoes = new VBox();

    Book livro;
    public HBoxBook(Book livro){
        super();

        this.livro = livro;

        imagemLivro.setImage(new Image(new File("MinhaLeitura/SRC/View/Images/livroAberto.png").toURI().toString()));

        titulo.getStyleClass().add("tituloLivro");
        titulo.setMinWidth(250);
        titulo.setMaxWidth(250);
        titulo.setText(livro.getTitle());

        autor.getStyleClass().add("autorLivro");
        autor.setText(livro.getAuthor());

        dadosLivro.getChildren().addAll(titulo, autor);
        dadosLivro.setAlignment(Pos.CENTER_LEFT);
        dadosLivro.setMinWidth(255);

        concluir.getStyleClass().add("concluirLeitura");
        concluir.setText("Concluir");
        Tooltip concluirLeitura = new Tooltip("Concluir leitura");
        concluir.setTooltip(concluirLeitura);
        concluir.setMinWidth(109);
        concluir.setAlignment(Pos.CENTER);
        editar.getStyleClass().add("editarLeitura");
        editar.setText("Editar");
        Tooltip editarLeitura = new Tooltip("Editar leitura");
        editar.setTooltip(editarLeitura);
        editar.setMinWidth(109);
        editar.setAlignment(Pos.CENTER);
        excluir.getStyleClass().add("excluirLeitura");
        excluir.setText("Excluir");
        Tooltip excluirLeitura = new Tooltip("Excluir leitura");
        excluir.setTooltip(excluirLeitura);
        excluir.setMinWidth(109);
        excluir.setAlignment(Pos.CENTER);

        botoes.getChildren().addAll(concluir,editar,excluir);
        botoes.setAlignment(Pos.CENTER);
        botoes.setSpacing(5);

        this.getStyleClass().add("containerEmLeitura");
        this.setAlignment(Pos.CENTER_LEFT);
        this.getChildren().addAll(imagemLivro, dadosLivro, botoes);
    }

    public Book getLivro() {
        return livro;
    }
}

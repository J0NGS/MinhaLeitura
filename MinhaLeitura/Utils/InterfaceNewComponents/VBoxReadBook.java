package Utils.InterfaceNewComponents;

import SRC.Model.VO.Book;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.File;

public class VBoxReadBook extends VBox {
    Label titulo = new Label();
    Label autor = new Label();

    ImageView imagemLivro = new ImageView();

    ImageView divisor = new ImageView();

    ImageView estrelas = new ImageView();

    Book livro;

    public VBoxReadBook(Book livro) {
        super();

        this.livro = livro;

        imagemLivro.setImage(new Image(new File("MinhaLeitura/SRC/View/Images/livroLido.png").toURI().toString()));
        imagemLivro.setTranslateY(-20);
        divisor.setImage(new Image(new File("MinhaLeitura/SRC/View/Images/separador.png").toURI().toString()));
        divisor.setTranslateY(5);
        estrelas.setImage(new Image(new File("MinhaLeitura/SRC/View/Images/star4.png").toURI().toString()));
        estrelas.setTranslateY(10);

        titulo.getStyleClass().add("tituloLivro");
        titulo.setMinWidth(150);
        titulo.setMaxWidth(150);
        titulo.setText(livro.getTitle());
        titulo.setTranslateY(-5);

        autor.getStyleClass().add("autorLivro");
        autor.setText(livro.getAuthor());
        autor.setTranslateY(-5);

        this.getStyleClass().add("containerFinalizados");
        this.setMinWidth(162.0);
        this.setMinHeight(215.0);
        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(imagemLivro, titulo, autor, divisor, estrelas);
    }

    public Book getLivro() {
        return livro;
    }
}

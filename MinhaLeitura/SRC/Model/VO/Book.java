/**
 * Classe que representa um livro no sistema
 * 
 * @Author João Gonçalo
 */
package SRC.Model.VO;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
* Construtor que recebe todos os argumentos necessários para criar um objeto Book.
* 
* @param id ID do livro
* @param title Título do livro
* @param author Autor do livro
* @param publishe Editora do livro
* @param releaseDate Data de lançamento do livro
* @param category Categoria do livro
*/
public class Book implements Serializable{
    private Long id;                    // id
    private String title;               // titulo do livro
    private String author;              // autor
    private String publishe;            // editora
    private LocalDate releaseDate;      // data de lançamento
    private String category;            // categoria


    // Construtor usando todos os argumentos
    public Book(Long id, String title, String author, String publishe, LocalDate releaseDate, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishe = publishe;
        this.releaseDate = releaseDate;
        this.category = category;
    }

    // Construtor vazio
    public Book() {
        this.id = null;
        this.title = null;
        this.author = null;
        this.publishe = null;
        this.releaseDate = null;
        this.category = null;
    }

    /*
     * --------------------------------------------------------------------
     * Getters e Setters
     * --------------------------------------------------------------------
     */


    /**
     * Retorna o ID do livro.
     * 
     * @return ID for the book
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Define o ID do livro.
     * 
     * @param id for the book
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Retorna o Titulo do livro.
     * 
     * @return Title for the book
     */
    public String getTitle() {
        return this.title;
    }
    /**
     * Define o Titulo do livro.
     * 
     * @param title for the book
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishe() {
        return this.publishe;
    }

    public void setPublishe(String publishe) {
        this.publishe = publishe;
    }

    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    //--------------------------------------------------------------------
    // Equals e hashcode

    /**
     * Compara dois objetos Book para verificar se são iguais.
     * @param book o objeto a ser comparado
     * @return true se os objetos são iguais, false caso contrário
     */
    @Override
    public boolean equals(Object book) {
        if (book == this)
            return true;
        if (!(book instanceof Book)) {
            return false;
        }
        Book o = (Book) book;
        return Objects.equals(id, o.id) && Objects.equals(title, o.title) && Objects.equals(author, o.author) && Objects.equals(publishe, o.publishe) && Objects.equals(releaseDate, o.releaseDate) && Objects.equals(category, o.category);
    }

    /**
     * Retorna o hashcode do objeto Book.
     * @return o hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

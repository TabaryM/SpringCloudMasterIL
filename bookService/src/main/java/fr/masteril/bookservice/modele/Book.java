package fr.masteril.bookservice.modele;

import javax.persistence.*;

/**
 * @author Tabary
 */
@Entity
public class Book {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isbn;
    private String title;
    private String author;
    private String type;
    private double price;

    public Book(String isbn, String title, String author, String type, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.type = type;
        this.price = price;
    }

    public Book() {
        this("", "", "", "", 0.0);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

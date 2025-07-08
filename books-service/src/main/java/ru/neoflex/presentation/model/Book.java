package ru.neoflex.presentation.model;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String author;
    private boolean status;
    private long bookuser;


    public Book(long id, String name, String author, boolean status, long bookuser) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.status = status;
        this.bookuser = bookuser;
    }

    public Book() {
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public long getBookuser() {
        return bookuser;
    }

    public void setBookuser(long bookuser) {
        this.bookuser = bookuser;
    }

    public String toString() {
        return "Account(id=" + this.getId() + ", name=" + this.getName() + ", surname=" + this.getAuthor() + ", status=" + this.getStatus() + ")";
    }
}

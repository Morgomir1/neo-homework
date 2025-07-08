package ru.neoflex.presentation.dto;

public class BookDto {
    private long id;
    private String name;
    private String author;
    private boolean status;
    private long bookuser;

    public BookDto() {
    }

    public BookDto(long id, String name, String author, boolean status, long bookuser) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.status = status;
        this.bookuser = bookuser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getBookuser() {
        return bookuser;
    }

    public void setBookuser(long bookuser) {
        this.bookuser = bookuser;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", status=" + status +
                ", user=" + bookuser +
                '}';
    }
}

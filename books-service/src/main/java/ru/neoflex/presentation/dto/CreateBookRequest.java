package ru.neoflex.presentation.dto;

import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.PostMapping;
import ru.neoflex.presentation.controller.BookController;

public class CreateBookRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String author;

    public CreateBookRequest(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public CreateBookRequest() {
    }

    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @PostMapping
    public BookDto createBook(BookController accountController) {
        System.out.println("Received request: " + this);
        return accountController.bookService.createBook(this);
    }
}

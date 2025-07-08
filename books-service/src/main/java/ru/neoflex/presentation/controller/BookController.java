package ru.neoflex.presentation.controller;

import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.neoflex.presentation.dto.BookDto;
import ru.neoflex.presentation.dto.BookRequest;
import ru.neoflex.presentation.dto.CreateBookRequest;
import ru.neoflex.presentation.service.BookService;

import java.util.List;

@Validated
@RestController
@RequestMapping("/v1/book")
public class BookController {

    public final BookService bookService;



    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public BookDto createBook(@RequestBody @Valid CreateBookRequest createBookRequest) {
        System.out.println("Received request: " + createBookRequest);
        return bookService.createBook(createBookRequest);
    }

    @GetMapping("/{bookId}")
    public BookDto getBook(@PathVariable("bookId") long bookId) {
        return bookService.getBook(bookId);
    }

    @GetMapping
    public List<BookDto> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping("/give")
    public BookDto giveBook(@RequestBody @Valid BookRequest request) {
        return bookService.giveBook(request);
    }

    @PostMapping("/refund")
    public BookDto refundBook(@RequestBody @Valid BookRequest request) {
        return bookService.refundBook(request);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable("bookId") long bookId) {
        bookService.deleteBook(bookId);
    }
}

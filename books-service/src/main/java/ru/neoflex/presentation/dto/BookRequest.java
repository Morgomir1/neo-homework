package ru.neoflex.presentation.dto;

import org.springframework.web.bind.annotation.PostMapping;
import ru.neoflex.presentation.controller.BookController;
import jakarta.validation.constraints.Min;

public class BookRequest {
    @Min(1)
    private long bookId;
    @Min(1)
    private long accountId;

    public BookRequest() {
    }

    public BookRequest(long bookId, long accountId) {
        this.bookId = bookId;
        this.accountId = accountId;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    @PostMapping(value = "/give")
    public BookDto giveBook(BookController accountController) {
        System.out.println("Received request: " + this);
        return accountController.giveBook(this);
    }

    @PostMapping(value = "/refund")
    public BookDto refundBook(BookController accountController) {
        System.out.println("Received request: " + this);
        return accountController.refundBook(this);
    }

    @Override
    public String toString() {
        return "GiveBookRequest{" +
                "bookId=" + bookId +
                ", accountId=" + accountId +
                '}';
    }
}

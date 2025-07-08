package ru.neoflex.presentation.service;

import feign.FeignException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.neoflex.presentation.client.AccountClient;
import ru.neoflex.presentation.dto.*;
import ru.neoflex.presentation.mapper.BookMapper;
import ru.neoflex.presentation.model.Book;
import ru.neoflex.presentation.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    @Autowired
    public AccountClient accountClient;

    public BookService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public Optional<AccountDto> getAccount(long id) {
        return accountClient.getAccount(id);
    }

    public BookDto giveBook(BookRequest createbookRequest) {
        Book book = bookMapper.toEntity(createbookRequest);
        Optional<AccountDto> account = getAccount(createbookRequest.getAccountId());
        if (account.isPresent()) {
            BookDto bookDto = getBook(createbookRequest.getBookId());
            if (bookDto.getBookuser() == 0) {
                bookDto.setBookuser(account.get().getId());
                bookDto.setStatus(true);
                bookRepository.save(bookMapper.fromDto(bookDto));
                return bookDto;
            }
        } else {
            return new BookDto();
        }
        return bookMapper.toDto(book);
    }

    public BookDto refundBook(BookRequest createbookRequest) {
        Book book = bookMapper.toEntity(createbookRequest);
        Optional<AccountDto> account = getAccount(createbookRequest.getAccountId());
        if (account.isPresent()) {
            BookDto bookDto = getBook(createbookRequest.getBookId());
            if (bookDto.getBookuser() == account.get().getId()) {
                bookDto.setBookuser(0);
                bookDto.setStatus(false);
                bookRepository.save(bookMapper.fromDto(bookDto));
                return bookDto;
            }
        } else {
            throw new EntityNotFoundException(String.valueOf(createbookRequest.getAccountId()));
        }
        return bookMapper.toDto(book);
    }

    public BookDto createBook(CreateBookRequest createbookRequest) {
        Book newbook = bookMapper.toEntity(createbookRequest);

        newbook = bookRepository.save(newbook);
        return bookMapper.toDto(newbook);
    }

    public BookDto getBook(long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(EntityNotFoundException::new);

        return bookMapper.toDto(book);
    }

    public List<BookDto> getBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map((bookMapper::toDto)).toList();
    }

    public void deleteBook(long bookId) {
        bookRepository.deleteById(bookId);
    }
}

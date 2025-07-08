package ru.neoflex.presentation.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.neoflex.presentation.dto.BookDto;
import ru.neoflex.presentation.dto.BookRequest;
import ru.neoflex.presentation.dto.CreateBookRequest;
import ru.neoflex.presentation.model.Book;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {

    BookDto toDto(Book account);

    Book fromDto(BookDto account);

    Book toEntity(CreateBookRequest createAccountRequest);

    Book toEntity(BookRequest createAccountRequest);
}

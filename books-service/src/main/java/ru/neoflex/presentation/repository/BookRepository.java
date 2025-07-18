package ru.neoflex.presentation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.neoflex.presentation.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}

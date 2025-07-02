package ru.neoflex.presentation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neoflex.presentation.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}

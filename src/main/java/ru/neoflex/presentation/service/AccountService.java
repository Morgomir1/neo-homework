package ru.neoflex.presentation.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import ru.neoflex.presentation.dto.AccountDto;
import ru.neoflex.presentation.dto.CreateAccountRequest;
import ru.neoflex.presentation.mapper.AccountMapper;
import ru.neoflex.presentation.model.Account;
import ru.neoflex.presentation.repository.AccountRepository;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    public AccountDto createAccount(CreateAccountRequest createAccountRequest) {
        Account newAccount = accountMapper.toEntity(createAccountRequest);

        newAccount = accountRepository.save(newAccount);
        return accountMapper.toDto(newAccount);
    }

    public AccountDto getUser(long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(EntityNotFoundException::new);

        return accountMapper.toDto(account);
    }

    public List<AccountDto> getAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((accountMapper::toDto)).toList();
    }

    public void deleteUser(long accountId) {
        accountRepository.deleteById(accountId);
    }
}

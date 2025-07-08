package ru.neoflex.presentation.client;

import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import ru.neoflex.presentation.dto.AccountDto;

import java.util.Optional;

@Component
public class AccountClientFallbackFactory implements FallbackFactory<AccountClient> {

    private static final Logger log = LoggerFactory.getLogger(AccountClientFallbackFactory.class);

    @Override
    public AccountClient create(Throwable cause) {
        return new AccountClient() {
            @Override
            public Optional<AccountDto> getAccount(long id) {
                if (cause instanceof FeignException) {
                    FeignException feignException = (FeignException) cause;
                    log.error("FeignException occurred for getAccount({}): status={}, message={}",
                              id, feignException.status(), feignException.getMessage());
                } else {
                    log.error("An unexpected error occurred for getAccount({}): {}", id, cause.getMessage(), cause);
                }
                return Optional.empty();
            }
        };
    }
}

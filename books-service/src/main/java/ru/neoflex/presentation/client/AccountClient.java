package ru.neoflex.presentation.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.neoflex.presentation.dto.AccountDto;

import java.util.Optional;

@FeignClient(value = "accountClient", url = "http://localhost:8080", path = "/v1/user", fallbackFactory = AccountClientFallbackFactory.class)
public interface AccountClient {

    @RequestMapping(method = RequestMethod.GET, value = "/{accountId}")
    Optional<AccountDto> getAccount(@PathVariable("accountId") long accountId);

}
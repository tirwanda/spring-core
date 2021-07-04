package tirwanda.dev.spring.service;

import tirwanda.dev.spring.entity.Account;

import java.math.BigDecimal;

public interface AccountService {
    public void transferMoney(Long sourceId, Long destinationId, BigDecimal balance);
    public Account getAccount(Long id);
}

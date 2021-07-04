package tirwanda.dev.spring.service.impl;

import tirwanda.dev.spring.entity.Account;
import tirwanda.dev.spring.repository.impl.AccountRepositoryImpl;
import tirwanda.dev.spring.service.AccountService;

import java.math.BigDecimal;

public class AccountServiceImpl implements AccountService {

    private AccountRepositoryImpl accountRepositoryImpl;

    public AccountServiceImpl(AccountRepositoryImpl accountRepositoryImpl) {
        this.accountRepositoryImpl = accountRepositoryImpl;
    }

    @Override
    public void transferMoney(Long sourceId, Long destinationId, BigDecimal balance) {
        Account sourceAccount = accountRepositoryImpl.find(sourceId);
        Account destinationSource = accountRepositoryImpl.find(destinationId);

        sourceAccount.setBalance(sourceAccount.getBalance().subtract(balance));
        destinationSource.setBalance(destinationSource.getBalance().add(balance));

        accountRepositoryImpl.update(sourceAccount);
        accountRepositoryImpl.update(destinationSource);
    }

    @Override
    public Account getAccount(Long id) {
        return accountRepositoryImpl.find(id);
    }

}

package tirwanda.dev.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tirwanda.dev.spring.entity.Account;
import tirwanda.dev.spring.repository.AccountRepository;
import tirwanda.dev.spring.service.AccountService;

import java.math.BigDecimal;

@Service(value = "accountService")
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Override
    public void transferMoney(Long sourceId, Long destinationId, BigDecimal balance) {
        Account sourceAccount = accountRepository.find(sourceId);
        Account destinationSource = accountRepository.find(destinationId);

        sourceAccount.setBalance(sourceAccount.getBalance().subtract(balance));
        destinationSource.setBalance(destinationSource.getBalance().add(balance));

        accountRepository.update(sourceAccount);
        accountRepository.update(destinationSource);
    }

    @Override
    public Account getAccount(Long id) {
        return accountRepository.find(id);
    }

    public AccountRepository getAccountRepositoryImpl() {
        return accountRepository;
    }

    @Autowired
    public void setAccountRepositoryImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
}

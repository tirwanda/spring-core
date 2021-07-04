package tirwanda.dev.spring.repository.impl;

import org.springframework.stereotype.Repository;
import tirwanda.dev.spring.entity.Account;
import tirwanda.dev.spring.repository.AccountRepository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    private Map<Long, Account> accountMap = new HashMap<>();
    {
        Account account1 = new Account();
        account1.setId(1L);
        account1.setAccountNumber("001");
        account1.setBalance(new BigDecimal(100_000));
        account1.setName("Edho");

        Account account2= new Account();
        account2.setId(2L);
        account2.setAccountNumber("002");
        account2.setBalance(new BigDecimal(200_000));
        account2.setName("Dwi");

        accountMap.put(account1.getId(), account1);
        accountMap.put(account2.getId(), account2);
    }

    @Override
    public void update(Account account) {
        accountMap.put(account.getId(), account);
    }

    @Override
    public Account find(Long id) {
        return accountMap.get(id);
    }
}

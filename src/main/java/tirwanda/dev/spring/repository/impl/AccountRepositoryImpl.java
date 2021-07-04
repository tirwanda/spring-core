package tirwanda.dev.spring.repository.impl;

import tirwanda.dev.spring.entity.Account;
import tirwanda.dev.spring.repository.AccountRepository;

import java.util.Map;

public class AccountRepositoryImpl implements AccountRepository {

    private Map<Long, Account> accountMap;

    @Override
    public void update(Account account) {
        accountMap.put(account.getId(), account);
    }

    @Override
    public Account find(Long id) {
        return accountMap.get(id);
    }

    public Map<Long, Account> getAccountMap() {
        return accountMap;
    }

    public void setAccountMap(Map<Long, Account> accountMap) {
        this.accountMap = accountMap;
    }
}

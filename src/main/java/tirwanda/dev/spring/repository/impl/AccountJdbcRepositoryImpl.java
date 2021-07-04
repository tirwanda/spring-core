package tirwanda.dev.spring.repository.impl;

import org.springframework.stereotype.Repository;
import tirwanda.dev.spring.entity.Account;
import tirwanda.dev.spring.repository.AccountRepository;

@Repository
public class AccountJdbcRepositoryImpl implements AccountRepository {
    @Override
    public void update(Account account) {

    }

    @Override
    public Account find(Long id) {
        return null;
    }
}

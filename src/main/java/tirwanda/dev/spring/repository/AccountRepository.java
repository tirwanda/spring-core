package tirwanda.dev.spring.repository;

import tirwanda.dev.spring.entity.Account;

public interface AccountRepository {
    public void update(Account account);
    public Account find(Long id);
}

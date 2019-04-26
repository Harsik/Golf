package golf.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import golf.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long>{

    Optional<Account> findByName(String username);
}
package vcs.com.project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vcs.com.project.Entity.Account;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByAccountNumber(int accountNumber);

    Account findByEmail(String email);

    @Modifying
    @Query(value = "delete from account where account_number = :accountNumber", nativeQuery = true)
    int deleteByAccount(@Param("accountNumber") int accountNumber);
}

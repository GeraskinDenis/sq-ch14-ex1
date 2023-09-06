package ru.geraskindenis.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import ru.geraskindenis.models.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {

	// SELECT * FROM account WHERE name = ?
	List<Account> findAccountsByName(String name);

	@Query("SELECT * FROM account WHERE amount = :amount")
	List<Account> findAccountsByAmount(BigDecimal amount);

	@Modifying
	@Query("UPDATE account SET amount = :amount WHERE id = :id")
	void changeAmount(long id, BigDecimal amount);

}

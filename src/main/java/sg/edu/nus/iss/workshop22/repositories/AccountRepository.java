package sg.edu.nus.iss.workshop22.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.workshop22.models.Account;

@Repository
public class AccountRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Retrieve list of all accounts
    public List<Account> findAllAccounts() {
        String sqlString = "select * from accounts";

        return jdbcTemplate.query(sqlString, new AccountMapper());
    }

    public Optional<Account> findAccountByAccountId(String account_id) {
        String sqlString = "select * from accounts where account_id = ?";
        try {
            Account result = jdbcTemplate.queryForObject(sqlString, new AccountMapper(), account_id);
            return Optional.of(result);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }

    }

    public boolean creditAccountBalance(String account_id, Double amount) {
        String sqlString = "update accounts set balance = balance + ? where account_id = ?";
        int updated = jdbcTemplate.update(sqlString, amount, account_id);
        return updated > 0;

    }

    public boolean debitAccountBalance(String account_id, Double amount) {
        String sqlString = "update accounts set balance = balance - ? where account_id = ?";
        int updated = jdbcTemplate.update(sqlString, amount, account_id);
        return updated > 0;

    }
    
}

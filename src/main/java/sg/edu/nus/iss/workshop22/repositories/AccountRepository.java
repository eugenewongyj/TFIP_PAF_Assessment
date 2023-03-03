package sg.edu.nus.iss.workshop22.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

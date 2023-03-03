package sg.edu.nus.iss.workshop22.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sg.edu.nus.iss.workshop22.models.Account;

public class AccountMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setAccount_id(rs.getString("account_id"));
        account.setName(rs.getString("name"));
        account.setBalance(rs.getDouble("balance"));
        return account;
    }
    
}

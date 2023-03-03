package sg.edu.nus.iss.workshop22.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.workshop22.models.Rsvp;

@Repository
public class RsvpRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Retrieving list using queryForRowSet
    public List<Rsvp> getAllRsvps() {
        String sqlString = "select * from rsvp";

        List<Rsvp> result = new ArrayList<>();

        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sqlString);

        while (sqlRowSet.next()) {
            Rsvp rsvp = new Rsvp();
            rsvp.setId(sqlRowSet.getInt("id"));
            rsvp.setFull_name(sqlRowSet.getString("full_name"));
            rsvp.setEmail(sqlRowSet.getString("email"));
            rsvp.setPhone(sqlRowSet.getString("phone"));
            rsvp.setConfirmation_date(sqlRowSet.getDate("confirmation_date"));
            rsvp.setComments(sqlRowSet.getString("comments"));
            result.add(rsvp);
        }

        return result;
    }

    // Retrieving list using query and BeanPropertyRowMapper
    public List<Rsvp> getAllRsvps2() {
        String sqlString = "select * from rsvp";

        List<Rsvp> result = jdbcTemplate.query(sqlString, BeanPropertyRowMapper.newInstance(Rsvp.class));

        return result;
    }

    // Retrieving list using query and RowMapper
    public List<Rsvp> getAllRsvps3() {
        String sqlString = "select * from rsvp";

        List<Rsvp> result = jdbcTemplate.query(sqlString, new RsvpMapper());

        return result;
    }

    // Retrieving list based on name using queryForRowSet
    public List<Rsvp> getRsvpsByName(String name) {
        String sqlString = "select * from rsvp where full_name like ?";

        name = "%%%s%%".formatted(name);

        List<Rsvp> result = new ArrayList<>();

        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sqlString, name);

        while (sqlRowSet.next()) {
            Rsvp rsvp = new Rsvp();
            rsvp.setId(sqlRowSet.getInt("id"));
            rsvp.setFull_name(sqlRowSet.getString("full_name"));
            rsvp.setEmail(sqlRowSet.getString("email"));
            rsvp.setPhone(sqlRowSet.getString("phone"));
            rsvp.setConfirmation_date(sqlRowSet.getDate("confirmation_date"));
            rsvp.setComments(sqlRowSet.getString("comments"));
            result.add(rsvp);
        }

        return result;
    }

    // Retrieving list based on name using query and BeanPropertyRowMapper
    public List<Rsvp> getRsvpsByName2(String name) {
        String sqlString = "select * from rsvp where full_name like ?";

        name = "%%%s%%".formatted(name);

        return jdbcTemplate.query(sqlString, BeanPropertyRowMapper.newInstance(Rsvp.class), name);
    }

    // Get Rsvp based on Id using SqlRowSet
    public Optional<Rsvp> getRsvpById(Integer id) {
        String sqlString = "select * from rsvp where id = ?";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sqlString, id);
        if (sqlRowSet.first()) {
            Rsvp rsvp = new Rsvp();
            rsvp.setId(sqlRowSet.getInt("id"));
            rsvp.setFull_name(sqlRowSet.getString("full_name"));
            rsvp.setEmail(sqlRowSet.getString("email"));
            rsvp.setPhone(sqlRowSet.getString("phone"));
            rsvp.setConfirmation_date(sqlRowSet.getDate("confirmation_date"));
            rsvp.setComments(sqlRowSet.getString("comments"));
            return Optional.of(rsvp);
        }
        return Optional.empty();
    }

    // Get Rsvp based on ID using queryForObject and BeanPropertyRowMapper
    public Rsvp getRsvpById2(Integer id) {
        String sqlString = "select * from rsvp where id = ?";
        Rsvp result = jdbcTemplate.queryForObject(sqlString, BeanPropertyRowMapper.newInstance(Rsvp.class), id);
        return result;
    }

    // Get Rsvp based on ID using queryForObject and RowMapper
    public Rsvp getRsvpById3(Integer id) {
        String sqlString = "select * from rsvp where id = ?";
        Rsvp result = jdbcTemplate.queryForObject(sqlString, new RsvpMapper(), id);
        return result;
    }

    // Get count
    public int getRsvpCount() {
        String sqlString = "select count(*) from rsvp";
        Integer result = jdbcTemplate.queryForObject(sqlString, Integer.class);
        return result;
    }

    // Get list of emails using queryForList
    public List<String> getAllRsvpEmails() {
        String sqlString = "select email from rsvp";

        List<String> result = jdbcTemplate.queryForList(sqlString, String.class);

        return result;
    }

    // Insert new rsvp
    public boolean addRsvp(Rsvp rsvp) {
        // Note that the id does not need to be inserted for this case because the id is set to auto increment in the database
        String sqlString = "insert into rsvp (full_name, email, phone, confirmation_date, comments) values (?, ?, ?, ?, ?)";
        int added = jdbcTemplate.update(sqlString, rsvp.getFull_name(), rsvp.getEmail(), rsvp.getPhone(), rsvp.getConfirmation_date(), rsvp.getComments());
        return added > 0;
    }

    // Update existing rsvp
    public boolean updateRsvp(Integer id, Rsvp rsvp) {
        String sqlString = "update rsvp set full_name = ?, email = ?, phone = ?, confirmation_date = ?, comments = ? where id = ?";
        int updated = jdbcTemplate.update(sqlString, rsvp.getFull_name(), rsvp.getEmail(), rsvp.getPhone(), rsvp.getConfirmation_date(), rsvp.getComments(), id);
        return updated > 0;

        
    }

 
    // public Rsvp getRsvpByEmail(String email) {
    //     // 
    //     return null;
        
    // }

    // // Update existing rsvp
    // // Assuming this is a rest controller. In which case, the email could be sent as a path variable or inside the rsvp object. Either way is does not affect
    // // the writing of the update method.
    // public boolean updateRsvp(String email, Rsvp rsvp) {
    //     // If this was a service method, then you would need to find whether the email exists first.
        
    //     // Assuming that the identifying field (eg email) can return 0, 1 or multiple rows
    //     // And I only want to update when there is one Rsvp
    //     String sqlString1 = "select * from rsvp where email = ?";
    //     List<Rsvp> rsvpList =



    //     String sqlString = "update rsvp set full_name = ?, email = ?, phone = ?, confirmation_date = ?, comments = ? where id = ?";
    //     int updated = jdbcTemplate.update(sqlString, rsvp.getFull_name(), rsvp.getEmail(), rsvp.getPhone(), rsvp.getConfirmation_date(), rsvp.getComments(), id);
    //     return updated > 0;

        
    // }

    // ==================================
    // This method is just to show that if you return many rows when calling queryForObject, IncorrectResultSizeDataAccessException
    // When zero rows are found, EmptyResultDataAccessException
    // So I will only call queryForObject when i explicity only want 1 row.
    public Rsvp getRsvpByNameUsingQueryForObject(String name) {
        String sqlString = "select * from rsvp where full_name = ?";

        return jdbcTemplate.queryForObject(sqlString, new RsvpMapper(), name);
    }

    //=============================
    // This method is just to show that if you are expecting only 1 or 0 rows because you are using an unique identifier
    // Typically you would use QueryForObject or QueryForRowSet like when checking for id
    // But technically you could also query.
    public Optional<Rsvp> getRsvpById4(Integer id) {
        String sqlString = "select * from rsvp where id = ?";
        List<Rsvp> result = jdbcTemplate.query(sqlString, new RsvpMapper(), id);
        if (result.size() == 1) {
            return Optional.of(result.get(0));
        }
        return Optional.empty();
    }

    

    

    



    
}

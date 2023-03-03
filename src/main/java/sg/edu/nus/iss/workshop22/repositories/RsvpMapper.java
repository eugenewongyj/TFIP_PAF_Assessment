package sg.edu.nus.iss.workshop22.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import sg.edu.nus.iss.workshop22.models.Rsvp;

public class RsvpMapper implements RowMapper<Rsvp> {

    @Override
    public Rsvp mapRow(ResultSet rs, int rowNum) throws SQLException {
        Rsvp rsvp = new Rsvp();
        rsvp.setId(rs.getInt("id"));
        rsvp.setFull_name(rs.getString("full_name"));
        rsvp.setEmail(rs.getString("email"));
        rsvp.setPhone(rs.getString("phone"));
        rsvp.setConfirmation_date(rs.getDate("confirmation_date"));
        rsvp.setComments(rs.getString("comments"));
        return rsvp;
    }
    
}

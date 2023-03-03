package sg.edu.nus.iss.workshop22.services;

import org.springframework.stereotype.Service;

@Service
public class RsvpService {

    // // Update existing rsvp
    // // Assuming this is a rest controller. In which case, the email could be sent as a path variable or inside the rsvp object. Either way is does not affect
    // // the writing of the update method.
    // public boolean updateRsvp(String email, Rsvp rsvp) {
    //     // If this was a service method, then you would need to find whether the email exists first.
        
    //     String sqlString = "update rsvp set full_name = ?, email = ?, phone = ?, confirmation_date = ?, comments = ? where id = ?";
    //     int updated = jdbcTemplate.update(sqlString, rsvp.getFull_name(), rsvp.getEmail(), rsvp.getPhone(), rsvp.getConfirmation_date(), rsvp.getComments(), id);
    //     return updated > 0;

        
    // }

    // // Assuming that the identifying field (eg email) can return 0, 1 or multiple rows
    
}

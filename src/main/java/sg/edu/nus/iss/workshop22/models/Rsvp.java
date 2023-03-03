package sg.edu.nus.iss.workshop22.models;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rsvp {

    private Integer id;

    private String full_name;

    private String email;

    private String phone;

    private Date confirmation_date;

    private String comments;
    
}

package sg.edu.nus.iss.workshop22.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sg.edu.nus.iss.workshop22.models.Rsvp;
import sg.edu.nus.iss.workshop22.repositories.RsvpRepository;

@RestController
@RequestMapping(path="/api/rsvp")
public class RsvpController {

    @Autowired
    private RsvpRepository rsvpRepository;

    // Retrieving list using queryForRowSet
    @GetMapping(path="/all")
    public List<Rsvp> getAllRsvps() {
        return rsvpRepository.getAllRsvps();
    }

    // Retrieving list using query and BeanPropertyRowMapper
    @GetMapping(path="/all2")
    public List<Rsvp> getAllRsvps2() {
        return rsvpRepository.getAllRsvps2();
    }

    // Retrieving list using query and RowMapper
    @GetMapping(path="/all3")
    public List<Rsvp> getAllRsvps3() {
        return rsvpRepository.getAllRsvps3();
    }

    // Retrieving list based on name using queryForRowSet
    @GetMapping(path="/name")
    public List<Rsvp> getRsvpsByName(@RequestParam("q") String name) {
        rsvpRepository.getRsvpsByName(name).forEach(rsvp -> System.out.println(rsvp.getConfirmation_date()));
        return rsvpRepository.getRsvpsByName(name);
    }

    // Retrieving list based on name using query and BeanPropertyRowMapper
    @GetMapping(path="/name2")
    public List<Rsvp> getRsvpsByName2(@RequestParam("q") String name) {
        rsvpRepository.getRsvpsByName(name).forEach(rsvp -> System.out.println(rsvp.getConfirmation_date()));
        return rsvpRepository.getRsvpsByName2(name);
    }

    // Get Rsvp based on Id using SqlRowSet
    @GetMapping(path="/id/{id}")
    public Rsvp getRsvpById(@PathVariable Integer id) {
        return rsvpRepository.getRsvpById(id).get();
    }

    // Get Rsvp based on ID using queryForObject and BeanPropertyRowMapper
    @GetMapping(path="/id2/{id}")
    public Rsvp getRsvpById2(@PathVariable Integer id) {
        return rsvpRepository.getRsvpById2(id);
    }

    // Get Rsvp based on ID using queryForObject and RowMapper
    @GetMapping(path="/id3/{id}")
    public Rsvp getRsvpById3(@PathVariable Integer id) {
        return rsvpRepository.getRsvpById3(id);
    }

    // Get count
    @GetMapping(path="/count")
    public int getRsvpCount() {
        return rsvpRepository.getRsvpCount();
    }

    // Get all emails
    @GetMapping(path="/emails")
    public List<String> getAllRsvpEmails() {
        return rsvpRepository.getAllRsvpEmails();
    }

    // Insert Rsvp
    @PostMapping
    public Boolean addRsvp(@RequestBody Rsvp rsvp) {
        System.out.println(rsvp.getConfirmation_date());
        return rsvpRepository.addRsvp(rsvp);
    }

    // Update Rsvp
    @PutMapping(path="/{id}")
    public Boolean updateRsvp(@PathVariable Integer id, @RequestBody Rsvp rsvp) {
        return rsvpRepository.updateRsvp(id, rsvp);
    }

    //=====================================================
    // When zero rows are found, EmptyResultDataAccessException
    // When more than 1 row are found, IncorrectResultSizeDataAccessException
    @GetMapping(path="/rsvpname")
    public Rsvp getRsvpByNameUsingQueryForObject(@RequestParam String name) {
        return rsvpRepository.getRsvpByNameUsingQueryForObject(name);
    }

    //=============================
    // This method is just to show that if you are expecting only 1 or 0 rows because you are using an unique identifier
    // Typically you would use QueryForObject or QueryForRowSet like when checking for id
    // But technically you could also query.
    @GetMapping(path="/id4/{id}")
    public Object getRsvpById4(@PathVariable Integer id) {
        Optional<Rsvp> rsvp = rsvpRepository.getRsvpById4(id);
        if (rsvp.isPresent()) {
            return rsvp.get();
        }

        return "Cannot find rsvp with id";
    }

 
    
}

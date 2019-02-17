package com.example.wbsp19devanshiganatraserverside.services;


import com.example.wbsp19devanshiganatraserverside.model.Person;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "*", allowCredentials = "true")
public class FacultyService {

    Person person1 = new Person (111111L, "d", "g", "jhff", 9909503664L, "dev", "gan");

    List<Person> persons = new ArrayList<Person>() {{
        add(person1);
    }};

    @PostMapping("/api/register")
    public Person register(@RequestBody Person person,
                         HttpSession session) {
        session.setAttribute("currentUser", person);
        persons.add(person);
        return person;
    }


    @PostMapping("/api/profile")
    public Person profile(HttpSession session) {
        Person currentUser = (Person)
                session.getAttribute("currentUser");
        return currentUser;
    }

    @PostMapping("/api/login")
    public Person login(@RequestBody Person credentials,
                          HttpSession session) {
        for (Person person : persons) {
            if( person.getFirstName().equals(credentials.getFirstName())
                    && person.getPassword().equals(credentials.getPassword())) {
                session.setAttribute("currentUser", person);
                return person;
            }
        }
        return null;
    }

    @PostMapping("/api/logout")
    public void logout
            (HttpSession session) {
        session.invalidate();
    }

    @GetMapping("/api/persons")
    public List<Person> findAllPersons() {

        return persons;
    }

    @GetMapping("/api/persons/{pid}")
    public Person findPersonById(@PathVariable("pid") Long id) {
        for (Person person : persons) {
            if (id == person.getId().longValue())
                return person;
        }
        return null;
    }


}

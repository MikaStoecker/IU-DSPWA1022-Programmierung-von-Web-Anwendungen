package org.iu.dspwa1022.springdata.controller;

import java.util.List;

import org.iu.dspwa1022.springdata.model.Person;
import org.iu.dspwa1022.springdata.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    /*@GetMapping
    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }*/

    @GetMapping
    public String getAllPeople(Model model) {
        model.addAttribute("people", personRepository.findAll());
        return "people";
    }
    @PostMapping
    public String createPerson(@ModelAttribute Person person, Model model) {
        model.addAttribute("person", personRepository.save(person));
        return "people";
    }
}

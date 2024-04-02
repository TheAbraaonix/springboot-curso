package carlos.holanda.springbootcurso.controller;

import carlos.holanda.springbootcurso.model.Person;
import carlos.holanda.springbootcurso.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping()
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable(value = "id") String id) {
        return personService.findById(id);
    }

    @PostMapping()
    public Person create(@RequestBody Person person) {
        return personService.create(person);
    }

    @PutMapping()
    public Person update(@RequestBody Person person) {
        return personService.update(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(value = "id") String id) {
        personService.delete(id);
    }
}

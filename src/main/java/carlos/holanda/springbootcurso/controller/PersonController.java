package carlos.holanda.springbootcurso.controller;

import carlos.holanda.springbootcurso.data.vo.v1.PersonVO;
import carlos.holanda.springbootcurso.data.vo.v2.PersonVOV2;
import carlos.holanda.springbootcurso.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping()
    public List<PersonVO> findAll() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public PersonVO findById(@PathVariable(value = "id") Long id) {
        return personService.findById(id);
    }

    @PostMapping()
    public PersonVO create(@RequestBody PersonVO person) {
        return personService.create(person);
    }

    @PostMapping("/v2")
    public PersonVOV2 createV2(@RequestBody PersonVOV2 person) {
        return personService.createV2(person);
    }

    @PutMapping("/{id}")
    public PersonVO update(@PathVariable(value = "id") Long id, @RequestBody PersonVO person) {
        return personService.update(id, person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

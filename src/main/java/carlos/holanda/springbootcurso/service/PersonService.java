package carlos.holanda.springbootcurso.service;

import carlos.holanda.springbootcurso.exception.RecordNotFoundException;
import carlos.holanda.springbootcurso.model.Person;
import carlos.holanda.springbootcurso.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository personRepository;

    public List<Person> findAll() {
        logger.info("Finding all people!");

        return personRepository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finding one person!");
        return personRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Record not found."));
    }

    public Person create(Person person) {
        logger.info("Creating one person!");
        return personRepository.save(person);
    }

    public Person update(Long id, Person person) {
        logger.info("Updating one person!");

        Person foundPerson = findById(id);

        foundPerson.setFirstName(person.getFirstName());
        foundPerson.setLastName(person.getLastName());
        foundPerson.setAddress(person.getAddress());
        foundPerson.setGender(person.getGender());

        return personRepository.save(foundPerson);
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");

        Person foundPerson = findById(id);
        personRepository.delete(foundPerson);
    }
}

package carlos.holanda.springbootcurso.service;

import carlos.holanda.springbootcurso.data.vo.v1.PersonVO;
import carlos.holanda.springbootcurso.exception.RecordNotFoundException;
import carlos.holanda.springbootcurso.mapper.DozzerMapper;
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

    public List<PersonVO> findAll() {
        logger.info("Finding all people!");

        return DozzerMapper.parseListObjects(personRepository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id) {
        logger.info("Finding one person!");

        var entity = personRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Record not found."));

        return DozzerMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO create(PersonVO person) {
        logger.info("Creating one person!");

        var entity = DozzerMapper.parseObject(person, Person.class);
        var vo = DozzerMapper.parseObject(personRepository.save(entity), PersonVO.class);

        return vo;
    }

    public PersonVO update(Long id, PersonVO person) {
        logger.info("Updating one person!");

        var entity = personRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Record not found."));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var vo = DozzerMapper.parseObject(personRepository.save(entity), PersonVO.class);
        return vo;
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");

        var entity = personRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Record not found."));
        personRepository.delete(entity);
    }
}

package carlos.holanda.springbootcurso.repository;

import carlos.holanda.springbootcurso.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}

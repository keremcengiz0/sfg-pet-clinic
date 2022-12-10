package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.entities.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {
}

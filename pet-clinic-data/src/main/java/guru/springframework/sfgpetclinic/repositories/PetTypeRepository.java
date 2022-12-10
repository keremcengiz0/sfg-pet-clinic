package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.entities.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}

package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.entities.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}

package guru.springframework.sfgpetclinic.repositories;

import guru.springframework.sfgpetclinic.entities.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}

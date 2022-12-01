package guru.springframework.sfgpetclinic.business;

import guru.springframework.sfgpetclinic.entities.Pet;
import guru.springframework.sfgpetclinic.entities.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}

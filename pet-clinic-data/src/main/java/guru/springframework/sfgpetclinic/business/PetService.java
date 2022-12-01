package guru.springframework.sfgpetclinic.business;

import guru.springframework.sfgpetclinic.entities.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}

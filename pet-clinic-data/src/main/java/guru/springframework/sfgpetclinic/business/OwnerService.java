package guru.springframework.sfgpetclinic.business;

import guru.springframework.sfgpetclinic.entities.Owner;

import java.util.Set;

public interface OwnerService {
    Owner findById(Long id);

    Owner findByLastName(String lastName);

    Owner save(Owner owner);

    Set<Owner> findAll();
}

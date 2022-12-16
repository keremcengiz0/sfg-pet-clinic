package guru.springframework.sfgpetclinic.business.abstracts;

import guru.springframework.sfgpetclinic.entities.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
    List<Owner> findAllByLastNameLike(String lastName);

}

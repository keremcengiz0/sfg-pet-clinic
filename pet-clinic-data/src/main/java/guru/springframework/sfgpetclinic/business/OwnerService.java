package guru.springframework.sfgpetclinic.business;

import guru.springframework.sfgpetclinic.entities.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);

}

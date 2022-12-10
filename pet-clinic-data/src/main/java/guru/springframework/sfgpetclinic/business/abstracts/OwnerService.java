package guru.springframework.sfgpetclinic.business.abstracts;

import guru.springframework.sfgpetclinic.entities.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);

}

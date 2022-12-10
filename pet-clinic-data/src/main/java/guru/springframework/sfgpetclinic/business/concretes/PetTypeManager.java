package guru.springframework.sfgpetclinic.business.concretes;

import guru.springframework.sfgpetclinic.business.abstracts.PetTypeService;
import guru.springframework.sfgpetclinic.entities.PetType;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("concretes")
public class PetTypeManager implements PetTypeService {

    private PetTypeRepository petTypeRepository;

    public PetTypeManager(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        this.petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        return this.petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return this.petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        this.petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        this.petTypeRepository.deleteById(aLong);
    }
}

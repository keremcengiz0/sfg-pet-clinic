package guru.springframework.sfgpetclinic.business.concretes;

import guru.springframework.sfgpetclinic.business.abstracts.VetService;
import guru.springframework.sfgpetclinic.entities.Vet;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import guru.springframework.sfgpetclinic.repositories.VetRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("concretes")
public class VetManager implements VetService {

    private VetRepository vetRepository;

    public VetManager(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        this.vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return this.vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return this.vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        this.vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        this.vetRepository.deleteById(aLong);
    }
}

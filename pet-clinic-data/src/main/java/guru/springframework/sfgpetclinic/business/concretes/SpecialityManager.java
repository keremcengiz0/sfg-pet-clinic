package guru.springframework.sfgpetclinic.business.concretes;

import guru.springframework.sfgpetclinic.business.abstracts.SpecialtyService;
import guru.springframework.sfgpetclinic.entities.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("concretes")
public class SpecialityManager implements SpecialtyService {

    private SpecialtyRepository specialtyRepository;

    public SpecialityManager(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        this.specialtyRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long aLong) {
        return this.specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality object) {
        return this.specialtyRepository.save(object);
    }

    @Override
    public void delete(Speciality object) {
        this.specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        this.specialtyRepository.deleteById(aLong);
    }
}

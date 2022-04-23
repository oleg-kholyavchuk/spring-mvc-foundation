package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.BreedingPlace;
import ru.itsjava.repository.AnimalRepository;
import ru.itsjava.repository.BreedingPlaceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@SuppressWarnings("all")
public class BreedingPlaceServiceImpl implements BreedingPlaceService{
    private final BreedingPlaceRepository breedingPlaceRepository;
    private final AnimalRepository animalRepository;

//    @Transactional
//    @Override
//    public void changeBreedingPlace(String oldBreedingPlace, String updatedBreedingPlace) {
//        BreedingPlace breedingPlaces = breedingPlaceRepository.getByBreedingPlace(oldBreedingPlace).get();
//        breedingPlaces.setName(updatedBreedingPlace);
//        breedingPlaceRepository.save(breedingPlaces);
//        System.out.println("Successfully saved!");
//    }

//    @Transactional(readOnly = true)
//    @Override
//    public void printBreedingPlace(String breedingPlace) {
//        BreedingPlace breedingPlaces = breedingPlaceRepository.getByBreedingPlace(breedingPlace).get();
//        System.out.println(breedingPlaces);
//    }

    @Transactional
    @Override
    public void createBreedingPlace(BreedingPlace breedingPlace) {
        breedingPlaceRepository.save(breedingPlace);
    }

    @Transactional(readOnly = true)
    @Override
    public BreedingPlace getBreedingPlaceById(long id) {
        return breedingPlaceRepository.findById(id).get();
    }

    @Transactional
    @Override
    public void deleteBreedingPlace(BreedingPlace breedingPlace) {
        animalRepository.deleteAllByBreedingPlace(breedingPlace);
        breedingPlaceRepository.delete(breedingPlace);
    }

    @Override
    public List<BreedingPlace> getAllBreedingPlaces() {
        return breedingPlaceRepository.findAll();
    }

    @Override
    public void updateBreedingPlace(BreedingPlace breedingPlace) {
        breedingPlaceRepository.save(breedingPlace);
    }
}

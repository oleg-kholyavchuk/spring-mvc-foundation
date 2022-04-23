package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.Animal;
import ru.itsjava.domain.BreedingPlace;
import ru.itsjava.repository.AnimalRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepository animalRepository;
    private final BreedingPlaceService breedingPlaceService;

    @Transactional(readOnly = true)
    @Override
    public void printAllAnimals() {
        System.out.println("All animals:");
        List<Animal> animals = animalRepository.findAll();
        System.out.println(animals);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    @Transactional
    @Override
    public void createAnimal(Animal animal) {
//        if(breedingPlaceRepository.findById(animal.getBreedingPlace()).isPresent()) {
//
//        }

//        List<BreedingPlace> breedingPlaces = animal.getBreedingPlace();
//        breedingPlaces.forEach(breedingPlace -> breedingPlace.setAnimal_id(animal.getId()));
//        animal.setBreedingPlace(breedingPlaces);
//        breedingPlaces.forEach(breedingPlace -> breedingPlaceRepository.save(breedingPlace) );
//        System.out.println("animal = " + animal);

        List<BreedingPlace> breedingPlace = animal.getBreedingPlace();
        System.out.println("breedingPlace = " + breedingPlace);


        breedingPlaceService.createBreedingPlace(animal.getBreedingPlace().get(0));

        List<BreedingPlace> breedingPlaceList = breedingPlaceService.getAllBreedingPlaces();
        breedingPlaceList.addAll(breedingPlace);
        System.out.println("breedingPlaceList = " + breedingPlaceList);

        animal.setBreedingPlace(breedingPlaceList);
        System.out.println("animal = " + animal);
        System.out.println();

        animalRepository.save(animal);

    }
}

package ru.itsjava.service;

import ru.itsjava.domain.BreedingPlace;

import java.util.List;

@SuppressWarnings("all")
public interface BreedingPlaceService {
    void createBreedingPlace(BreedingPlace breedingPlace);
    BreedingPlace getBreedingPlaceById(long id);
    void deleteBreedingPlace(BreedingPlace breedingPlace);
    List<BreedingPlace> getAllBreedingPlaces();
    void updateBreedingPlace(BreedingPlace breedingPlace);
}

package ru.itsjava.service;

import ru.itsjava.domain.Pet;

@SuppressWarnings("all")
public interface PetService {
    void changePet(String oldPet, String updatedPet);
    void printPet(String pet);
    void createGenre(Pet pet);
    Pet getPetById(long id);
    void deletePetById(long id);
}

package ru.itsjava.service;

import ru.itsjava.domain.Pet;

import java.util.List;

@SuppressWarnings("all")
public interface PetService {
    void changePet(String oldPet, String updatedPet);
    void printPet(String pet);
    void createPet(Pet pet);
    Pet getPetById(long id);
    void deletePet(Pet pet);
    List<Pet> getAllPets();
    void updatePet(Pet pet);
}

package ru.itsjava.service;

import ru.itsjava.domain.Pet;

@SuppressWarnings("all")
public interface PetService {
    void changePet(String oldPet, String updatedPet);
    void printPet(String pet);
    Pet getPetById(long id);
}

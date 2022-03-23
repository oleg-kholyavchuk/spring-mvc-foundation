package ru.itsjava.service;

import ru.itsjava.domain.Pet;

import java.util.List;

@SuppressWarnings("all")
public interface PetService {
    void changePet(String oldPet, String updatedPet);
    void printPet(String pet);
    List<Pet> getAllPet();
}

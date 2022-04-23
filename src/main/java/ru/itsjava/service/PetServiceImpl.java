package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.Pet;
import ru.itsjava.repository.AnimalRepository;
import ru.itsjava.repository.PetRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@SuppressWarnings("ALL")
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;
    private final AnimalRepository animalRepository;

    @Transactional
    @Override
    public void changePet(String oldPet, String updatedPet) {
        Pet pets = petRepository.getByPet(oldPet).get();
        pets.setPet(updatedPet);
        petRepository.save(pets);
        System.out.println("Successfully saved!");
    }

    @Transactional(readOnly = true)
    @Override
    public void printPet(String pet) {
        Pet pets = petRepository.getByPet(pet).get();
        System.out.println(pets);
    }

    @Transactional
    @Override
    public void createPet(Pet pet) {
        petRepository.save(pet);
    }

    @Transactional(readOnly = true)
    @Override
    public Pet getPetById(long id) {
        return petRepository.findById(id).get();
    }

    @Transactional
    @Override
    public void deletePet(Pet pet) {
        animalRepository.deleteAllByPet(pet);
        petRepository.delete(pet);
    }

    @Override
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    @Override
    public void updatePet(Pet pet) {
        petRepository.save(pet);
    }
}

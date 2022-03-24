package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.Pet;
import ru.itsjava.repository.PetRepository;

@Service
@RequiredArgsConstructor
@SuppressWarnings("ALL")
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;

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

    @Transactional(readOnly = true)
    @Override
    public void createGenre(Pet pet) {
        petRepository.save(pet);
    }

    @Transactional(readOnly = true)
    @Override
    public Pet getPetById(long id) {
        return petRepository.findById(id).get();
    }

    @Transactional
    @Override
    public void deletePetById(long id) {
        petRepository.deleteById(id);
    }
}

package ru.itsjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itsjava.domain.Animal;
import ru.itsjava.domain.Pet;

import java.util.Optional;

@SuppressWarnings("all")
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    void deleteAllByPet(Pet pet);
    Optional<Animal> findAnimalByBreedAndPet(String breed, Pet pet);
}

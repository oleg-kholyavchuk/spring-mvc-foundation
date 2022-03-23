package ru.itsjava.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.Animal;
import ru.itsjava.repository.AnimalRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepository animalRepository;

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
}

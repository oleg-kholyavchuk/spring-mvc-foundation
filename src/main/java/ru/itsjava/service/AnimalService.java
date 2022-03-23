package ru.itsjava.service;

import ru.itsjava.domain.Animal;

import java.util.List;

@SuppressWarnings("all")
public interface AnimalService {
    void printAllAnimals();
    List<Animal> getAllAnimals();
}

package ru.itsjava.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itsjava.domain.Animal;
import ru.itsjava.domain.BreedingPlace;
import ru.itsjava.domain.Pet;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@SuppressWarnings("all")
public class AnimalDto {
    private String id;
    private String breed;
    private String pet;
    private String breedingPlace;

    public static Animal fromDto(AnimalDto animalDto) {
        if(animalDto.id == null) {
            animalDto.id = "0";
        }
        long id = Long.parseLong(animalDto.id);
        Pet pet = new Pet(0L, animalDto.pet);
        String[] splitPlaces = animalDto.breedingPlace.split(",");

        List<BreedingPlace> places = new ArrayList<>();
        for (String splitPlace: splitPlaces) {
            places.add(new BreedingPlace(0L, splitPlace, id));
        }
        return new Animal(id, animalDto.breed, pet, places);
    }


    public static AnimalDto toDto(Animal animal) {
        String id = String.valueOf(animal.getId());
        String breed = animal.getBreed();
        String pet = animal.getPet().getPet();

        StringBuilder stringBuilder = new StringBuilder();
        for (BreedingPlace place: animal.getBreedingPlace()) {
            stringBuilder.append(place.getName()).append(",");
        }
//        stringBuilder.deleteCharAt(stringBuilder.length() - 1 );

        String places = stringBuilder.toString();

        return new AnimalDto(id, breed, pet, places);
    }
}

package ru.itsjava.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itsjava.domain.BreedingPlace;

@Data
@AllArgsConstructor
@SuppressWarnings("all")
public class BreedingPlaceDto {
    private String id;
    private String name;
    private String animal_id;

    public static BreedingPlace fromDto(BreedingPlaceDto breedingPlaceDto) {
        if(breedingPlaceDto.id == null) {
            breedingPlaceDto.id = "0";
        }

        if(breedingPlaceDto.animal_id == null) {
            breedingPlaceDto.animal_id = "0";
        }

        return new BreedingPlace(Long.parseLong(breedingPlaceDto.id), breedingPlaceDto.name, Long.parseLong(breedingPlaceDto.animal_id));
    }

    public static BreedingPlaceDto toDto(BreedingPlace breedingPlace) {
        return new BreedingPlaceDto(String.valueOf(breedingPlace.getId())
                , breedingPlace.getName(), String.valueOf(breedingPlace.getAnimal_id()));
    }
}

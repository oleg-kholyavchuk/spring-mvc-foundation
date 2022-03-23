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

    public BreedingPlace fromDto(BreedingPlaceDto breedingPlaceDto) {
        long id = Long.parseLong(breedingPlaceDto.id);
        long animal_id = Long.parseLong(breedingPlaceDto.animal_id);

        return new BreedingPlace(id, breedingPlaceDto.name, animal_id);
    }

    public BreedingPlaceDto toDto(BreedingPlace breedingPlace) {
        String id = String.valueOf(breedingPlace.getId());
        String breedingPlaces = breedingPlace.getName();
        String animal_id = String.valueOf(breedingPlace.getAnimal_id());

        return new BreedingPlaceDto(id, breedingPlaces, animal_id);
    }
}

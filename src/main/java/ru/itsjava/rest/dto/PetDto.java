package ru.itsjava.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itsjava.domain.Pet;

@Data
@AllArgsConstructor
@SuppressWarnings("all")
public class PetDto {
    private String id;
    private String pet;

    public static Pet fromDto(PetDto petDto) {
        long id = Long.parseLong(petDto.id);

        return new Pet(id, petDto.pet);
    }

    public static PetDto toDto(Pet pet) {
        String id = String.valueOf(pet.getId());
        String pets = pet.getPet();

        return new PetDto(id, pets);
    }
}

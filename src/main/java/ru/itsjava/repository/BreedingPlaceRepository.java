package ru.itsjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itsjava.domain.BreedingPlace;

import java.util.Optional;

public interface BreedingPlaceRepository extends JpaRepository<BreedingPlace, Long> {
//    Optional<BreedingPlace> getByBreedingPlace(String breedingPlace);
}

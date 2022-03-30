package ru.itsjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itsjava.domain.BreedingPlace;


public interface BreedingPlaceRepository extends JpaRepository<BreedingPlace, Long> {
}

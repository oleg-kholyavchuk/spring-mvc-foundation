package ru.itsjava.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itsjava.domain.BreedingPlace;
import ru.itsjava.rest.dto.BreedingPlaceDto;
import ru.itsjava.service.BreedingPlaceService;


import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@SuppressWarnings("all")
public class BreedingPlaceController {
    private final BreedingPlaceService breedingPlaceService;

    @GetMapping("breedingPlace/{id}")
    public String getPage(@PathVariable("id") long id, Model model) {
        model.addAttribute("breedingPlace", BreedingPlaceDto.toDto(breedingPlaceService.getBreedingPlaceById(id)));
        return "get-breedingPlace-page";
    }

    @GetMapping("/breedingPlace")
    public String genresPage(Model model) {
        List<BreedingPlaceDto> allBreedingPlacesDto = breedingPlaceService.getAllBreedingPlaces()
                .stream().map(BreedingPlaceDto::toDto).collect(Collectors.toList());

        model.addAttribute("breedingPlaces", allBreedingPlacesDto);
        return "breedingPlaces-page";
    }

    @GetMapping("breedingPlace/add")
    public String addPage() {
        return "add-breedingPlace-page";
    }

    @PostMapping("breedingPlace/add")
    public String afterAddPost(BreedingPlaceDto breedingPlaceDto) {
        breedingPlaceService.createBreedingPlace(BreedingPlaceDto.fromDto(breedingPlaceDto));
        return "redirect:/";
    }

    @GetMapping("breedingPlace/{id}/edit")
    public String editPage(@PathVariable("id") long id, Model model) {
        BreedingPlace breedingPlaceById = breedingPlaceService.getBreedingPlaceById(id);
        model.addAttribute("breedingPlaceDto", BreedingPlaceDto.toDto(breedingPlaceById));
        return "edit-breedingPlace-page";
    }

    @PostMapping("breedingPlace/{id}/edit")
    public String afterEditPage(BreedingPlaceDto breedingPlaceDto) {
        breedingPlaceService.updateBreedingPlace(BreedingPlaceDto.fromDto(breedingPlaceDto));
        return "redirect:/";
    }

    @GetMapping("breedingPlace/{id}/delete")
    public String deletePage(@PathVariable("id") long id, Model model) {
        BreedingPlace breedingPlaceById = breedingPlaceService.getBreedingPlaceById(id);
        model.addAttribute("breedingPlaceDto", BreedingPlaceDto.toDto(breedingPlaceById));
        return "delete-breedingPlace-page";
    }

    @PostMapping("breedingPlace/{id}/delete")
    public String afterDeletePage(BreedingPlaceDto breedingPlaceDto) {
        breedingPlaceService.deleteBreedingPlace(BreedingPlaceDto.fromDto(breedingPlaceDto));
        return "redirect:/";
    }
}

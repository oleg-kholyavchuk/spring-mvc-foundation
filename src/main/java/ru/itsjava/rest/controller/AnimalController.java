package ru.itsjava.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itsjava.domain.Animal;
import ru.itsjava.rest.dto.AnimalDto;
import ru.itsjava.service.AnimalService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@SuppressWarnings("all")
public class AnimalController {
    private final AnimalService animalService;

    @GetMapping("/")
    public String animalPage(Model model) {
        List<Animal> allAnimal = animalService.getAllAnimals();
        List<AnimalDto> animalDtos = new ArrayList<>();

        for (Animal animal : allAnimal) {
            animalDtos.add(AnimalDto.toDto(animal));
        }
        model.addAttribute("animal", animalDtos);
        return "animal-page";
    }

    @GetMapping("animal/add")
    public String addPage() {
        return "add-animal-page";
    }

    @PostMapping("animal/add")
    public String afterAddPost(AnimalDto animalDto) {
        animalService.createAnimal(AnimalDto.fromDto(animalDto));
        return "redirect:/";
    }
}

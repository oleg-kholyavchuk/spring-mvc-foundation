package ru.itsjava.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itsjava.domain.Pet;
import ru.itsjava.rest.dto.PetDto;
import ru.itsjava.service.PetService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@SuppressWarnings("all")
public class PetController {
    private final PetService petService;

    @GetMapping("pet/{id}")
    public String getPage(@PathVariable("id") long id, Model model) {
        model.addAttribute("pet", PetDto.toDto(petService.getPetById(id)));
        return "get-pet-page";
    }

    @GetMapping("/")
    public String genresPage(Model model) {
        List<PetDto> allGenresDto = petService.getAllPets()
                .stream().map(PetDto::toDto).collect(Collectors.toList());

        model.addAttribute("pets", allGenresDto);
        return "pets-page";
    }

    @GetMapping("pet/add")
    public String addPage() {
        return "add-pet-page";
    }

    @PostMapping("pet/add")
    public String afterAddPost(PetDto petDto) {
        petService.createGenre(PetDto.fromDto(petDto));
        return "redirect:/";
    }

    @GetMapping("pet/{id}/edit")
    public String editPage(@PathVariable("id") long id, Model model) {
        Pet petById = petService.getPetById(id);
        model.addAttribute("petDto", PetDto.toDto(petById));
        return "edit-pet-page";
    }

    @PostMapping("pet/{id}/edit")
    public String afterEditPage(PetDto petDto) {
        petService.updatePet(PetDto.fromDto(petDto));
        return "redirect:/";
    }

    @GetMapping("pet/{id}/delete")
    public String deletePage(@PathVariable("id") long id, Model model) {
        Pet petById = petService.getPetById(id);
        model.addAttribute("petDto", PetDto.toDto(petById));
        return "delete-pet-page";
    }

    @PostMapping("pet/{id}/delete")
    public String afterDeletePage(PetDto petDto) {
        petService.deletePet(PetDto.fromDto(petDto));
        return "redirect:/";
    }
}

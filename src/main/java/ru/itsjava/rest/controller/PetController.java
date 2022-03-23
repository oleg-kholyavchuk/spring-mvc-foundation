package ru.itsjava.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itsjava.domain.Pet;
import ru.itsjava.rest.dto.PetDto;
import ru.itsjava.service.PetService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@SuppressWarnings("all")
public class PetController {
    private final PetService petService;


    @GetMapping("/pets")
    public String getAll(Model model) {
        List<Pet> allPet = petService.getAllPet();
        List<PetDto> petDtos = new ArrayList<>();

        for (Pet pet: allPet) {
            petDtos.add(PetDto.toDto(pet));
        }

        model.addAttribute("pets", petDtos);
        return "pets-all";
    }
}

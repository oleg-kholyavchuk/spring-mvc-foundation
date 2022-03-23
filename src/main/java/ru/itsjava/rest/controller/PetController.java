package ru.itsjava.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itsjava.rest.dto.PetDto;
import ru.itsjava.service.PetService;

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
}

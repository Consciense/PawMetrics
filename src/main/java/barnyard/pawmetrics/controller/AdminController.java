package barnyard.pawmetrics.controller;

import barnyard.pawmetrics.domain.entity.Account;
import barnyard.pawmetrics.domain.entity.Breed;
import barnyard.pawmetrics.domain.entity.PetType;
import barnyard.pawmetrics.service.BreedService;
import barnyard.pawmetrics.service.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private PetTypeService petTypeService;
    @Autowired
    private BreedService breedService;

    @GetMapping
    public String adminPage(@AuthenticationPrincipal Account currentUser,
                            @ModelAttribute("petType") PetType petType,
                            @ModelAttribute("breed") Breed breed,
                            Model model) {
        model.addAttribute("breeds", breedService.getAll());
        model.addAttribute("petTypes", petTypeService.getAllTypes());
        return "admin";
    }

    @Transactional
    @PostMapping("/addBreed")
    public String addBreed(@AuthenticationPrincipal Account currentUser,
                           @ModelAttribute("breed") Breed breed) {
        breedService.add(breed);
        return "redirect:/admin";
    }

    @Transactional
    @PostMapping("/addPetType")
    public String addPetType(@AuthenticationPrincipal Account currentUser,
                             @ModelAttribute("petType") PetType petType) {
        petTypeService.add(petType);
        return "redirect:/admin";
    }

    @Transactional
    @PostMapping("/deleteBreed")
    public String deleteBreed(@AuthenticationPrincipal Account currentUser,
                              @ModelAttribute String breedName) {
        breedService.deleteByBreedName(breedName);
        return "redirect:/admin";
    }

    @Transactional
    @PostMapping("/deletePetType")
    public String deleteType(@AuthenticationPrincipal Account currentUser,
                             @ModelAttribute String petTypeName) {
        petTypeService.deleteByPetType(petTypeName);
        return "redirect:/admin";
    }
}

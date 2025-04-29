package barnyard.pawmetrics.controller;

import barnyard.pawmetrics.domain.entity.Breed;
import barnyard.pawmetrics.domain.entity.PetType;
import barnyard.pawmetrics.service.BreedService;
import barnyard.pawmetrics.service.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String adminPage() {
        return "admin";
    }

    @PostMapping("/addBreed")
    public String addBreed(@ModelAttribute Breed breed) {
        breedService.add(breed);
        return "admin";
    }

    @PostMapping("/addPetType")
    public String addPetType(@ModelAttribute PetType type) {
        petTypeService.add(type);
        return "admin";
    }

    @PostMapping("/deleteBreed")
    public String deleteBreed(@ModelAttribute String breedName) {
        breedService.deleteByBreedName(breedName);
        return "admin";
    }

    @PostMapping("/deletePetType")
    public String deleteType(@ModelAttribute String petTypeName) {
        petTypeService.deleteByPetType(petTypeName);
        return "admin";
    }
}

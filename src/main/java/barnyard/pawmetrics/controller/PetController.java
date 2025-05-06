package barnyard.pawmetrics.controller;

import barnyard.pawmetrics.domain.dto.PetDTO;
import barnyard.pawmetrics.domain.entity.Account;
import barnyard.pawmetrics.domain.entity.Pet;
import barnyard.pawmetrics.domain.enums.PetGender;
import barnyard.pawmetrics.service.AccountService;
import barnyard.pawmetrics.service.BreedService;
import barnyard.pawmetrics.service.PetService;
import barnyard.pawmetrics.service.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pets")
public class PetController {
    @Autowired
    private PetService petService;
    @Autowired
    private PetTypeService petTypeService;
    @Autowired
    private BreedService breedService;
    @Autowired
    private AccountService accountService;

    @GetMapping
    public String pet(@AuthenticationPrincipal Account currentUser,
                      Model model,
                      @ModelAttribute("petDTO") PetDTO petDTO) {
        model.addAttribute("genders", PetGender.values());
        model.addAttribute("pets", petService.getAccountPets());
        model.addAttribute("breeds", breedService.getAll());
        model.addAttribute("petTypes", petTypeService.getAllTypes());
        return "pet";
    }

    @PostMapping("/add")
    public String addPet(@AuthenticationPrincipal Account currentUser, PetDTO dto) {
        List<Pet> pets = accountService.getCurrentUser().getPets();
        if (pets.stream().map(Pet::getName).anyMatch(petName -> petName.equals(dto.getName()))) {
            return "pet";
        }
        petService.savePet(dto);
        return "redirect:/pets";
    }

    @PostMapping("/edit")
    public String updatePet(@AuthenticationPrincipal Account currentUser, PetDTO dto) {
        petService.savePet(dto);
        return "redirect:/pets";
    }

    @PostMapping("/delete")
    public String deletePet(@ModelAttribute("petId") Long petId) {
        petService.deleteById(petId);
        return "redirect:/pets";
    }
}

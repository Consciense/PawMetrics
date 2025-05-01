package barnyard.pawmetrics.controller;

import barnyard.pawmetrics.domain.dto.PetDTO;
import barnyard.pawmetrics.domain.entity.Pet;
import barnyard.pawmetrics.service.AccountService;
import barnyard.pawmetrics.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static java.lang.String.format;

@Controller
@RequestMapping("/pets")
public class PetController {
    @Autowired
    private PetService petService;
    @Autowired
    private AccountService accountService;

    @GetMapping
    public String pet(Model model) {
        model.addAttribute("loggedIn", true);
        return "pet";
    }

    @PostMapping("/add")
    public String addPet(PetDTO dto, Model model, BindingResult bindingResult) {
        List<Pet> pets = accountService.getCurrentUser().getPets();
        if (pets.stream().map(Pet::getName).anyMatch(petName -> petName.equals(dto.getName()))) {
            bindingResult.rejectValue("name", format("Pet named as %s already exists", dto.getName()));
            return "pet";
        }
        petService.savePet(dto);
        return "pet";
    }

    @PostMapping("/edit")
    public String updatePet(PetDTO dto, Model model, BindingResult bindingResult) {
        return "redirect:/pet";
    }

    @PostMapping("/delete")
    public String deletePet(PetDTO dto, Model model) {
        return "redirect:/pet";
    }
}

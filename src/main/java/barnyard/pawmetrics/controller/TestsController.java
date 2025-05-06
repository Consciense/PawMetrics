package barnyard.pawmetrics.controller;

import barnyard.pawmetrics.domain.dto.BloodTestResultDTO;
import barnyard.pawmetrics.domain.entity.Account;
import barnyard.pawmetrics.domain.entity.Pet;
import barnyard.pawmetrics.service.PetService;
import barnyard.pawmetrics.service.TestsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tests")
public class TestsController {
    @Autowired
    private TestsService testsService;
    @Autowired
    private PetService petService;

    @GetMapping
    public String tests(@AuthenticationPrincipal Account currentUser,
                        @ModelAttribute("dto") BloodTestResultDTO dto,
                        Model model) {
        List<Pet> pets = petService.getAccountPets();
        model.addAttribute("pets", pets);
        model.addAttribute("tests",testsService.getBloodTestResults(pets));
        model.addAttribute("conclusions", testsService.bindTestResults(testsService.getBloodTestResults(pets)));
        return "tests";
    }

    @PostMapping("/add")
    public String addTest(@ModelAttribute("dto") BloodTestResultDTO dto){
        testsService.save(dto);
        return "redirect:/tests";
    }

    @GetMapping("/petStatistics")
    public String petStatistics(@RequestParam("petId") Long petId, Model model){
        model.addAttribute("pet", petService.getPetById(petId));
        return "petStatistics";
    }
}

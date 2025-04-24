package barnyard.pawmetrics.controller;

import barnyard.pawmetrics.domain.dto.RegistrationDTO;
import barnyard.pawmetrics.repository.AccountRepository;
import barnyard.pawmetrics.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountRepository repository;

    @GetMapping("/registration")
    public String registration(@ModelAttribute RegistrationDTO registrationDTO) {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute RegistrationDTO dto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword", "Passwords do not match");
            return "registration";
        }
        if (repository.existsByEmail(dto.getEmail())) {
            bindingResult.rejectValue("email", "Email address already in use");
            return "registration";
        }
        if (repository.existsByUsername(dto.getUsername())) {
            model.addAttribute("errorMessage", "Username is already in use");
            return "registration";
        }
        accountService.create(dto);
        return "redirect:/account/login";
    }

//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String login(@Valid LoginDTO loginDTO, Model model) {
//        if(accountService.login(loginDTO)){
//            return "redirect:/";
//        } else {
//            model.addAttribute("WrongUsernameOrPassword", "Wrong username or password");
//            return "login";
//        }
//    }
//
//    @GetMapping("/edit")
//    public String edit() {
//        return "edit";
//    }
//
//    @PutMapping("/edit")
//    public String edit(Account account) {
//        accountService.edit(account);
//        return "redirect:/";
//    }
//
//    @GetMapping
//    public String delete() {
//        return "deleteAccount";
//    }
//    @DeleteMapping
//    public String delete(Account account) {
//        return "redirect:/";
//    }
}

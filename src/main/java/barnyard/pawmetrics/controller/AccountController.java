package barnyard.pawmetrics.controller;


import barnyard.pawmetrics.domain.dto.AccountDTO;
import barnyard.pawmetrics.domain.dto.LoginDTO;
import barnyard.pawmetrics.domain.dto.RegistrationDTO;
import barnyard.pawmetrics.domain.entity.Account;
import barnyard.pawmetrics.repository.AccountRepository;
import barnyard.pawmetrics.service.AccountService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public String registration(@ModelAttribute("dto") RegistrationDTO dto) {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("dto") RegistrationDTO dto, BindingResult bindingResult, Model model) {
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

    @GetMapping("/login")
    public String login(@ModelAttribute("dto") LoginDTO dto) {
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("dto") LoginDTO dto, Model model) {
        if (accountService.login(dto))
            return "redirect:/home";
        else {
            if (!repository.existsByUsername(dto.getUsername()))
                model.addAttribute("errorMessage", "Incorrect username");
            else
                model.addAttribute("errorMessage", "Incorrect password");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            request.getSession().invalidate();
            return "redirect:/";
        }
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@AuthenticationPrincipal Account currentUser) {
        return "deleteAccount";
    }

    @PostMapping("/delete")
    public String delete(@AuthenticationPrincipal Account currentUser, @RequestParam String username, Model model) {
        if (!accountService.havePermissionToDelete(username)) {
            model.addAttribute("errorMessage", "Wrong username");
            return "deleteAccount";
        }
        repository.delete(accountService.getByUsername(username));
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@AuthenticationPrincipal Account currentUser) {
        return "editAccount";
    }

    @PostMapping("/edit/password")
    public String editPassword(@AuthenticationPrincipal Account currentUser, @RequestParam String password) {
        accountService.updatePassword(password);
        return "redirect:/account/";
    }

    @PostMapping("/edit/photo")
    public String editPhoto(@AuthenticationPrincipal Account currentUser, @RequestParam String photo) {
        accountService.updatePhoto(photo);
        return "redirect:/account";
    }

    @PostMapping("/edit")
    public String edit(@AuthenticationPrincipal Account currentUser, @Valid @ModelAttribute AccountDTO dto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "editAccount";
        }
        accountService.update(dto);
        return "redirect:/account";
    }
}

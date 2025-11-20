package my.first.app.Controller;

import my.first.app.DTO.UserRegDTO;
import my.first.app.Service.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }
    
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    
    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new UserRegDTO());
        return "register";
    }
    
    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") UserRegDTO registrationDto,
                               BindingResult result,
                               Model model) {
        
        if (userService.usernameExists(registrationDto.getUsername())) {
            result.rejectValue("username", "error.user", "Username already exists");
        }
        
        if (result.hasErrors()) {
            return "register";
        }
        
        userService.registerUser(registrationDto);
        return "redirect:/login?success";
    }
}

package az.budaqli.userauthenticationsystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class SecuredControllers {
    @GetMapping
    public String showDashboard() {
        return String.format("Hello, user %s!","username");
    }
}
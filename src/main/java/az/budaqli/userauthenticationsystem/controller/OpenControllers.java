package az.budaqli.userauthenticationsystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class OpenControllers {
    @GetMapping
    public String getHome() {
        return "Welcome, stranger!";
    }
}

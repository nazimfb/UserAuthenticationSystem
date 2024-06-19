package az.budaqli.userauthenticationsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class SecuredControllers {

    @GetMapping
    public String showDashboard() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        if (authentication.getPrincipal() instanceof OAuth2User oAuth2User) {
            username = (String) oAuth2User.getAttributes().get("name"); //name,email,password etc.
        }

        return String.format("Hello, user %s! \n %s", username, "You can log out following this url: /logout");
    }
}

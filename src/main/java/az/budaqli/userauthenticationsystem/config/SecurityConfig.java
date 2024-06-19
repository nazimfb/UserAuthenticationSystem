package az.budaqli.userauthenticationsystem.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/h2-console/*").permitAll()
                        .requestMatchers("/register", "/login").permitAll()
                        .anyRequest().permitAll()
                )
                .oauth2Login(Customizer.withDefaults())
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout(LogoutConfigurer::permitAll)
                .build();

//        http.csrf(AbstractHttpConfigurer::disable)
//                .cors(Customizer.withDefaults())
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/api/v1/auth/*").permitAll()
//                        .requestMatchers("/map").permitAll() // Allow access to /map without authentication
//                        .requestMatchers(HttpMethod.GET, "/api/v1/stops").permitAll()
//                        .requestMatchers(HttpMethod.GET, "/dashboard").hasAnyAuthority("USER", "ADMIN")
//                        .requestMatchers(HttpMethod.GET, "/api/v1/routes/waypoints").hasAnyAuthority("USER", "ADMIN")
//                        .requestMatchers(HttpMethod.GET, "/api/v1/trams/active").hasAnyAuthority("USER", "ADMIN")
//                        .requestMatchers("/api/v1/*").hasAuthority("ADMIN")
//                        .anyRequest().authenticated())
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .permitAll());
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .sessionManagement(Customizer.withDefaults())
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
//        return http.build();
    }
}

package de.banglashop.hossain.backendbanglashop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) // Deaktiviert CSRF-Schutz, falls du REST-Endpunkte hast
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/nutzer/**").permitAll() // Erlaubt Zugriff auf alle /nutzer-Endpunkte
                        .anyRequest().authenticated() // Alle anderen Endpunkte erfordern Authentifizierung
                );
        return http.build();
    }
}

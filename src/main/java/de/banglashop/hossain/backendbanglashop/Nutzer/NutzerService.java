package de.banglashop.hossain.backendbanglashop.Nutzer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class NutzerService {

    @Autowired
    private NutzerRepository nutzerRepository;


    public Nutzer save(Nutzer nutzer) {
        return nutzerRepository.save(nutzer);
    }

    public Nutzer get(Long id) {
        return nutzerRepository.findById(String.valueOf(id)).orElseThrow(RuntimeException::new);
    }

    public List<Nutzer> getAllNutzer() {
        return nutzerRepository.findAll();
    }


    public Nutzer createNutzer(Nutzer nutzer) {
        // Passwort hashen (z. B. BCrypt)
        nutzer.setPassword(new BCryptPasswordEncoder().encode(nutzer.getPassword()));
        nutzer.setCreatedAt(LocalDateTime.now());
        nutzer.setUpdatedAt(LocalDateTime.now());
        Nutzer savedNutzer = nutzerRepository.save(nutzer);

        System.out.println("Neuer Nutzer erstellt: " + savedNutzer);
        return savedNutzer;
    }


    public Nutzer getNutzerById(String id) {
        return nutzerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nutzer nicht gefunden mit ID: " + id));
    }



}




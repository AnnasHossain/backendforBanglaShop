package de.banglashop.hossain.backendbanglashop.NutzerTest;

import de.banglashop.hossain.backendbanglashop.Nutzer.Nutzer;
import de.banglashop.hossain.backendbanglashop.Nutzer.NutzerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@SpringBootTest    // für ganze Anwendung testen
@DataJpaTest // nur für DB-Interaktion testen
@Import(NutzerService.class) // Importiert explizit die Service-Klasse
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY) //damit SpringBoot die H2-DB für den Test benutzt
public class NutzerServiceTest {

    @Autowired
    private NutzerService nutzerService;

    @Test
    public void testPasswordHashing() {
        // Arrange: Nutzer erstellen
        Nutzer nutzer = new Nutzer();
        nutzer.setName("Max Mustermann");
        nutzer.setEmail("max@example.com");
        nutzer.setPassword("meinPasswort123"); // Klartext

        // Act: Nutzer speichern
        Nutzer savedNutzer = nutzerService.createNutzer(nutzer);

        // Assert: Überprüfen, dass das Passwort gehasht wurde
        assertNotEquals("meinPasswort123", savedNutzer.getPassword()); // Das Passwort darf nicht im Klartext sein
        assertTrue(new BCryptPasswordEncoder().matches("meinPasswort123", savedNutzer.getPassword())); // Das gehashte Passwort muss mit dem Klartext übereinstimmen
    }

}

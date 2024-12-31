package de.banglashop.hossain.backendbanglashop.NutzerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.banglashop.hossain.backendbanglashop.Nutzer.Nutzer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application.properties")
public class NutzerControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private ObjectMapper objectMapper; // Für JSON <-> Objekt Konvertierung

    private final RestTemplate restTemplate = new RestTemplate();

    @Test
    public void testPostMapping_CreateNutzer() {
        // Arrange: Nutzer erstellen
        Nutzer nutzer = new Nutzer();
        nutzer.setSurname("Mustermann");
        nutzer.setName("Max");
        nutzer.setEmail("max@example.com");
        nutzer.setPassword("test123");
        nutzer.setRole("student");
        nutzer.setCreatedAt(LocalDateTime.now());
        nutzer.setUpdatedAt(LocalDateTime.now());

        String url = "http://localhost:" + port + "/nutzer";

        // Act: POST-Request senden
        ResponseEntity<Nutzer> response = restTemplate.postForEntity(url, nutzer, Nutzer.class);

        // Assert: Überprüfen, dass der Nutzer korrekt erstellt wurde
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getId());
        assertEquals("Max", response.getBody().getName());
    }

    @Test
    public void testGetMapping_GetNutzer() {
        // Arrange: Ein Nutzer sollte bereits in der Datenbank sein
        String url = "http://localhost:" + port + "/nutzer";

        Nutzer nutzer = new Nutzer();
        nutzer.setSurname("Mustermann");
        nutzer.setName("Max");
        nutzer.setAddresse("whateverman");
        nutzer.setGeburtsdatum(LocalDate.of(2001,03,29));
        nutzer.setEmail("max2@example.com");
        nutzer.setPassword("test123");
        nutzer.setRole("kunde");
        nutzer.setCreatedAt(LocalDateTime.now());
        nutzer.setUpdatedAt(LocalDateTime.now());

        // Nutzer erstellen
        ResponseEntity<Nutzer> postResponse = restTemplate.postForEntity(url, nutzer, Nutzer.class);
        assertNotNull(postResponse.getBody());
        String nutzerId = postResponse.getBody().getId();

        // Act: GET-Request senden
        ResponseEntity<Nutzer> getResponse = restTemplate.getForEntity(url + "/" + nutzerId, Nutzer.class);

        // Assert: Überprüfen, dass der richtige Nutzer abgerufen wurde
        assertEquals(HttpStatus.OK, getResponse.getStatusCode());
        assertNotNull(getResponse.getBody());
        assertEquals(nutzerId, getResponse.getBody().getId());
        assertEquals("Mustermann", getResponse.getBody().getSurname());
    }
}

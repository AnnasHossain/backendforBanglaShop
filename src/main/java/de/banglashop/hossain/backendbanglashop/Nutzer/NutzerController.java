package de.banglashop.hossain.backendbanglashop.Nutzer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/nutzer")
public class NutzerController {

    @Autowired
    private NutzerService nutzerService;

    @PostMapping
    public ResponseEntity<Nutzer> createNutzer(@RequestBody Nutzer nutzer) {
        Nutzer createdNutzer = nutzerService.createNutzer(nutzer);
        return new ResponseEntity<>(createdNutzer, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nutzer> getNutzerById(@PathVariable String id) {
        Nutzer nutzer = nutzerService.getNutzerById(id);
        return new ResponseEntity<>(nutzer, HttpStatus.OK);
    }

    // alle Nutzer abrufen
    @GetMapping
    public ResponseEntity<List<Nutzer>> getAllNutzer() {
        List<Nutzer> nutzerList = nutzerService.getAllNutzer(); //getAllNutzer muss im Service hinz werden damit klappt
        return new ResponseEntity<>(nutzerList, HttpStatus.OK);
    }
}

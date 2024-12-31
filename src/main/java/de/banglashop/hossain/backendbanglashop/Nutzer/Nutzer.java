package de.banglashop.hossain.backendbanglashop.Nutzer;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
public class Nutzer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String surname;
    private String name;
    private String addresse;
    private LocalDate geburtsdatum;
    private String email;
    private String password;
    private String role; // "customer" or "admin"
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    // Es fehlen hier Zahlungsdaten vom Kunden zum Speichern

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddresse(String whateverman) {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public LocalDate getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(LocalDate geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nutzer nutzer = (Nutzer) o;
        return Objects.equals(id, nutzer.id) && Objects.equals(surname, nutzer.surname) && Objects.equals(name, nutzer.name) && Objects.equals(addresse, nutzer.addresse) && Objects.equals(geburtsdatum, nutzer.geburtsdatum) && Objects.equals(email, nutzer.email) && Objects.equals(password, nutzer.password) && Objects.equals(role, nutzer.role) && Objects.equals(createdAt, nutzer.createdAt) && Objects.equals(updatedAt, nutzer.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, addresse, geburtsdatum, email, password, role, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "Nutzer{" +
                "id='" + id + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", addresse='" + addresse + '\'' +
                ", geburtsdatum=" + geburtsdatum +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}


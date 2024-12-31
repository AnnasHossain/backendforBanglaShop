package de.banglashop.hossain.backendbanglashop.Nutzer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutzerRepository extends JpaRepository<Nutzer, String> {

}

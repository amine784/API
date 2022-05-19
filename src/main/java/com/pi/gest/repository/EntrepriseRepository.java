package com.pi.gest.repository;

import com.pi.gest.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository  extends JpaRepository<Entreprise,Integer > {
}

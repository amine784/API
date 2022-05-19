package com.pi.gest.repository;

import com.pi.gest.model.LigneVente;
import com.pi.gest.model.Vente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VenteRepository extends JpaRepository <Vente ,Integer> {


    //Optional<Vente> findVentesByCode(String code);
}

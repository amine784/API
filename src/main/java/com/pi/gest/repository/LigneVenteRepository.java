package com.pi.gest.repository;

import com.pi.gest.model.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface LigneVenteRepository extends JpaRepository <LigneVente, Integer > {



 List<LigneVente> findAllByArticleId(Integer idArticle);

    //List<LigneVente> findAllByVenteId(Integer id);
}

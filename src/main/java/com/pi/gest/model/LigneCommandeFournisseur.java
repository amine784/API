package com.pi.gest.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class LigneCommandeFournisseur extends AbstactEntity {

     @ManyToOne
     @JoinColumn(name = "idarticle")
     private Article article;

    @ManyToOne
    @JoinColumn(name = "idCommandeFournisseur")
     private CommandeFournisseur commandeFournisseur;


    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "prixUnitaire")
    private BigDecimal prixUnitaire;



    @Column(name = "identreprise")
    private Integer idEntreprise;


}

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
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class LigneVente extends AbstactEntity{

    @ManyToOne
    @JoinColumn(name="idVente")
    private Vente vente;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    private Instant dateVente;


    private String comment;
}

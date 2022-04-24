package com.pi.gest.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class LigneCommandeClient extends AbstactEntity{

    @ManyToOne
    @JoinColumn(name = "idArcticle")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "idCommandeClient")
    private Article commandeClient;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;
}

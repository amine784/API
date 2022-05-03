package com.pi.gest.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@SuperBuilder
public class LigneCommandeClient extends AbstactEntity{

    @ManyToOne
    @JoinColumn(name = "idArcticle")
    private Article article;

    @ManyToOne
    @JoinColumn(name = "idCommandeClient")
    private CommandeClient commandeClient;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;


    private Integer idEntreprise;
}

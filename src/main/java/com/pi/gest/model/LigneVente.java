package com.pi.gest.model;

import com.pi.gest.dto.ArticleDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.Instant;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class LigneVente extends AbstactEntity{

    @ManyToOne
    @JoinColumn(name="idVente")
    private Vente vente;

    private Article article;
    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    private Instant dateVente;

    private Integer idEntreprise;

    private String comment;
}

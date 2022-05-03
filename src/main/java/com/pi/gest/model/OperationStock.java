package com.pi.gest.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

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
public class OperationStock extends AbstactEntity{


    private Instant dateOperationStock;

    private BigDecimal quantite;


    @ManyToOne
    @JoinColumn(name="idArticle")
    private Article article;

    private TypeOperationStock typeOperationStock;

    private SourceOperationStock sourceOperationStock;
    private Integer idEntreprise;
}

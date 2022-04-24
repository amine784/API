package com.pi.gest.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
public class OperationStock extends AbstactEntity{


    private Instant dateOperationStock;

    private BigDecimal quantite;


    @ManyToOne
    @JoinColumn(name="idArticle")
    private Article article;

    private TypeOperationStock typeOperationStock;
}

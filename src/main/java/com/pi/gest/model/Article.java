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

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Article extends AbstactEntity{

    private String codeArticle ;
    private String designation ;
    private String ImageArticle;

    @ManyToOne
    @JoinColumn(name = "IdCategory")
    private  Category category;


    @Column(name="prixUnitaireHorsTaxe")
    private BigDecimal prixUnitaireHT;

    @Column(name="TauxTva")
    private BigDecimal TVA;

    private BigDecimal prixUnitaireTTC;
}

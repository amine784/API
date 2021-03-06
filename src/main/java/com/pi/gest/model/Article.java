package com.pi.gest.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "article")
public class Article extends AbstactEntity{

    private String codeArticle ;
    private String designation ;
    private String ImageArticle;
    private Integer idEntreprise;




    @Column(name="prixUnitaireHorsTaxe")
    private BigDecimal prixUnitaireHT;

    @Column(name="TauxTva")
    private BigDecimal TVA;

    private BigDecimal prixUnitaireTTC;






    @OneToMany(mappedBy = "article")
    private List<LigneCommandeClient> ligneCommandeClients;

    @OneToMany(mappedBy = "article")
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;

    @OneToMany(mappedBy = "article")
    private List<OperationStock> operationStocks;


    @ManyToOne
    @JoinColumn(name = "idCategory")
    private Category category;


    @OneToMany(mappedBy = "article")
    private List<LigneVente> ligneVente;



}

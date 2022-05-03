package com.pi.gest.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.List;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Vente  extends AbstactEntity{

    @Column(name = "codeVente")
    private String codeVente;

    @Column(name = "dateVente")
    private Instant dateVente;


    @Column(name="commentaire")
    private String commentaire;

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @OneToMany(mappedBy = "vente")
    private List<LigneVente> ligneVentes;
}

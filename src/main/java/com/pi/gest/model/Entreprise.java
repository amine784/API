package com.pi.gest.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Entreprise extends AbstactEntity{

    @Embedded
    private Address adresse;



    @Column(name = "nomEntreprise")
    private String nomEntreprise;

    @Column(name = "codeFiscal")
    private String codeFiscal;

    @Column(name = "photo")
    private String imageEntreprise;

    @Column(name = "Email")
    private String email;

    @Column(name = "numberPhone")
    private String numtel;

    @Column(name = "webSite")
    private String webSite;


    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "entreprise")
    private List<Utilisateur> utilisateurs;

}

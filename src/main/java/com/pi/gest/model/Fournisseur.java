package com.pi.gest.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

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
public class Fournisseur extends AbstactEntity{

    private String firstName;
    private String lastName;
    private String picFournisseur;
    private String emailFournisseur;
    private String numberFournisseur;

    private Integer idEntreprise;

    @Embedded
    private Address address;


    @OneToMany(mappedBy = "fournisseur")
    private List<CommandeFournisseur> commandeFournisseurs;
}

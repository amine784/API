package com.pi.gest.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Utilisateur extends AbstactEntity{

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    @Embedded
    private Address adresse;

    private String imageUser;

    @JoinColumn(name = "idEntreprise")
    @ManyToOne
    private Entreprise entreprise;


    @OneToMany(mappedBy = "user")
    private List<Role> role ;
}

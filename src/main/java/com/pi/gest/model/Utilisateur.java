package com.pi.gest.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
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

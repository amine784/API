package com.pi.gest.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Role extends AbstactEntity{

    private String roleName;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private Utilisateur user;
}

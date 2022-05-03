package com.pi.gest.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Embeddable;
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
public class Client extends AbstactEntity{

    private String firstName;
    private String lastName;
    private String picClient;
    private String emailClient;
    private String numberClient;
    private Integer idEntreprise;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "client")
    private List<CommandeClient> commandeClients;
}

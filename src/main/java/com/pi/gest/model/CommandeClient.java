package com.pi.gest.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@SuperBuilder
public class CommandeClient extends AbstactEntity{

    private String codeCommandeClient;
    private Instant dateCommandeClient;
    private Integer idEntreprise;

    @Column(name = "statusommande")
    @Enumerated(EnumType.STRING)
    private StatusCommande statusCommande;

    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;

    @OneToMany(mappedBy = "commandeClient")
    private List<LigneCommandeClient> ligneCommandeClients;
}

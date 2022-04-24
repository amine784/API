package com.pi.gest.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class Address  implements Serializable {
    private String addressOne;
    private String addressTwo;
    private String ville;
    private String codePostale;
    private String pays;
}

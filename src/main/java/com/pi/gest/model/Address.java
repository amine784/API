package com.pi.gest.model;


import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Builder
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

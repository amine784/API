package com.pi.gest.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Category extends AbstactEntity{

    @Column(name = "code")
    private String code;
    private String designationCategory;


    @Column(name = "identreprise")
    private Integer idEntreprise;

    @OneToMany(mappedBy = "category")
    private List<Article> articles;
}

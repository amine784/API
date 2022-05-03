package com.pi.gest.model;


import lombok.*;
import lombok.experimental.SuperBuilder;

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

    private String codeCategory;
    private String designationCategory;

    @OneToMany(mappedBy = "category")
    private List<Article> articles;
}

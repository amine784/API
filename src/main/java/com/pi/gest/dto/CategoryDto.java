package com.pi.gest.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pi.gest.model.Category;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Builder
@Data
public class CategoryDto {

    private Integer id;

    private String codeCategory;
    private String designationCategory;


    @JsonIgnore
    private List<ArticleDto> articles;

    public static CategoryDto fromEntity(Category category){
        if (category == null) {
            //exception
            return null;
        }
        return CategoryDto.builder()
                .id(category.getId())
                .codeCategory(category.getDesignationCategory())
                .codeCategory(category.getCodeCategory())
                .build();
    }

    public static Category toEntity(CategoryDto categoryDto){
        if(categoryDto == null){
            return null;
        }
        Category category = new Category();
        category.setCodeCategory(categoryDto.getCodeCategory());
        category.setDesignationCategory(categoryDto.getDesignationCategory());

        return(category);
    }
}

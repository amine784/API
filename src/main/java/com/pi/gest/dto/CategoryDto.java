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

    private String code;
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
                .code(category.getDesignationCategory())
                .code(category.getCode())
                .build();
    }

    public static Category toEntity(CategoryDto categoryDto){
        if(categoryDto == null){
            return null;
        }
        Category category = new Category();
        category.setCode(categoryDto.getCode());
        category.setDesignationCategory(categoryDto.getDesignationCategory());

        return(category);
    }
}

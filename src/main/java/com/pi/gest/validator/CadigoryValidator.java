package com.pi.gest.validator;

import com.pi.gest.dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CadigoryValidator {
    public static List<String> validator (CategoryDto categoryDto){
        List<String> errors = new ArrayList<>();

        if (categoryDto == null || !StringUtils.hasLength(categoryDto.getCodeCategory())) {
            errors.add("Veuillez saisir un  code valide  de la categorie");
        }
        return errors;
    }
}

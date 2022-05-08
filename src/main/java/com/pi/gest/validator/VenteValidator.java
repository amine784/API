package com.pi.gest.validator;

import com.pi.gest.dto.VenteDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class VenteValidator {


    public static List<String> validate(VenteDto venteDto) {
        List<String> errors = new ArrayList<>();
        if (venteDto == null) {
            errors.add("code de la commande");
            errors.add("date de la commande");
            return errors;
        }

        if (!StringUtils.hasLength(venteDto.getCodeVente())){
            errors.add("code de la commande");
        }
        if (venteDto.getDateVente() == null) {
            errors.add("date de la commande");
        }

        return errors;
    }

}

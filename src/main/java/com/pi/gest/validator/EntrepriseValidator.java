package com.pi.gest.validator;

import com.pi.gest.dto.EntrepriseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {

    public static List<String> validate(EntrepriseDto entrepriseDto) {
        List<String> errors = new ArrayList<>();
        if (entrepriseDto == null) {
            errors.add(" nom de l'entreprise");
            errors.add("description de l'entreprise");
            errors.add("code fiscal de l'entreprise");
            errors.add("email de l'entreprise");
            errors.add(" numero de telephone de l'entreprise");
            errors.addAll(AddressValidator.validate(null));
            return errors;
        }

        if (!StringUtils.hasLength(entrepriseDto.getNomEntreprise())) {
            errors.add(" nom de l'entreprise");
        }
        if (!StringUtils.hasLength(entrepriseDto.getDescription())) {
            errors.add(" description de l'entreprise");
        }
        if (!StringUtils.hasLength(entrepriseDto.getDescription())) {
            errors.add("code fiscal de l'entreprise");
        }
        if (!StringUtils.hasLength(entrepriseDto.getEmail())) {
            errors.add("email de l'entreprise");
        }
        if (!StringUtils.hasLength(entrepriseDto.getNumtel())) {
            errors.add("numero de telephone de l'entreprise");
        }

        errors.addAll(AddressValidator.validate(entrepriseDto.getAdresse()));
        return errors;
    }
}

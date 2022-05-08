package com.pi.gest.validator;

import com.pi.gest.dto.FournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {

    public static List<String> validate(FournisseurDto fournisseurDto) {
        List<String> errors = new ArrayList<>();

        if (fournisseurDto == null) {
            errors.add("nom du fournisseur");
            errors.add("prenom du fournisseur");
            errors.add("Mail du fournisseur");
            errors.add("numero de telephone du fournisseur");
            errors.addAll(AddressValidator.validate(null));
            return errors;
        }

        if (!StringUtils.hasLength(fournisseurDto.getFirstName())) {
            errors.add("nom du fournisseur");
        }
        if (!StringUtils.hasLength(fournisseurDto.getLastName())) {
            errors.add("prenom du fournisseur");
        }
        if (!StringUtils.hasLength(fournisseurDto.getEmailFournisseur())) {
            errors.add("Veuillez renseigner le Mail du fournisseur");
        }
        if (!StringUtils.hasLength(fournisseurDto.getNumberFournisseur())) {
            errors.add("numero de telephone du fournisseur");
        }
        errors.addAll(AddressValidator.validate(fournisseurDto.getAddress()));
        return errors;
    }
}

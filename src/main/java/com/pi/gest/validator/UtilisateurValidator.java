package com.pi.gest.validator;

import com.pi.gest.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {
    public static List<String> validate(UtilisateurDto utilisateurDto) {
        List<String> errors = new ArrayList<>();

        if (utilisateurDto == null) {
            errors.add("Veuillez saisir le nom,prenon ,mot de passe et l'adresse  de l'utilisateur");
            errors.addAll(AddressValidator.validate(null));
            return errors;
        }

        if (!StringUtils.hasLength(utilisateurDto.getFirstName())) {
            errors.add("nom d'utilisateur");
        }
        if (!StringUtils.hasLength(utilisateurDto.getLastName())) {
            errors.add("prenom d'utilisateur");
        }
        if (!StringUtils.hasLength(utilisateurDto.getEmail())) {
            errors.add("email d'utilisateur");
        }
        if (!StringUtils.hasLength(utilisateurDto.getPassword())) {
            errors.add("mot de passe d'utilisateur");
        }

        errors.addAll(AddressValidator.validate(utilisateurDto.getAdresse()));

        return errors;
    }

}

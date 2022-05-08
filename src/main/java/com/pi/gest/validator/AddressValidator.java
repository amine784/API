package com.pi.gest.validator;

import com.pi.gest.dto.AddressDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AddressValidator {


    public static List<String> validate(AddressDto adresseDto) {
        List<String> errors = new ArrayList<>();

        if (adresseDto == null) {
            errors.add("Veuillez saisir votre adresse'");
            errors.add("Veuillez saisir votre ville'");
            errors.add("Veuillez saisir le nom votre  pays'");
            errors.add("Veuillez saisir un code postal valide");
            return errors;
        }
        if (!StringUtils.hasLength(adresseDto.getAddressOne()) ) {
            if (!StringUtils.hasLength(adresseDto.getAddressTwo())) {
                errors.add("Veuillez saisir une adresse valide'");
            }
        }
        if (!StringUtils.hasLength(adresseDto.getVille())) {
            errors.add("Veuillez saisir un nom de la ville'");
        }
        if (!StringUtils.hasLength(adresseDto.getPays())) {
            errors.add("Veuillez saisir un nom du pays valide");
        }
        return errors;
    }
}

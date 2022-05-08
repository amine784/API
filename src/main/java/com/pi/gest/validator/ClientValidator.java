package com.pi.gest.validator;

import com.pi.gest.dto.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {

    public static List<String> validate(ClientDto clientDto) {
        List<String> errors = new ArrayList<>();

        if (clientDto == null) {
            errors.add("Veuillez renseigner le nom du client");
            errors.add("Veuillez renseigner le prenom du client");
            errors.add("Veuillez renseigner le Mail du client");
            errors.add("Veuillez renseigner le numero de telephone du client");
            errors.addAll(AddressValidator.validate(null));
            return errors;
        }

        if (!StringUtils.hasLength(clientDto.getFirstName())) {
            errors.add("Veuillez saisir le nom du client");
        }
        if (!StringUtils.hasLength(clientDto.getLastName())) {
            errors.add("Veuillez saisir le prenom du client");
        }
        if (!StringUtils.hasLength(clientDto.getEmailClient())) {
            errors.add("Veuillez renseigner le Mail du client");
        }
        if (!StringUtils.hasLength(clientDto.getNumberClient())) {
            errors.add("Veuillez renseigner le numero de telephone du client");
        }
        errors.addAll(AddressValidator.validate(clientDto.getAddress()));
        return errors;
    }
}

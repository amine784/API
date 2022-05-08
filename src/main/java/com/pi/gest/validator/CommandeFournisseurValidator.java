package com.pi.gest.validator;

import com.pi.gest.dto.CommandeFournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandeFournisseurValidator {


    public static List<String> validate(CommandeFournisseurDto commandeFournisseurDto) {
        List<String> errors = new ArrayList<>();
        if (commandeFournisseurDto == null) {
            errors.add("Veuillez saisir le code de la commande");
            errors.add("Veuillez saisir la date de la commande");
            errors.add("Veuillez saisir l'etat de la commande");
            errors.add("Veuillez saisir le client");
            return errors;
        }

        if (!StringUtils.hasLength(commandeFournisseurDto.getCodeCmdFournisseur())) {
            errors.add("Veuillez saisir le code de la commande");
        }
        if (commandeFournisseurDto.getDateCommande() == null) {
            errors.add("Veuillez saisir la date de la commande");
        }
       // if (!StringUtils.hasLength(dto.getEtatCommande().toString())) {
          //  errors.add("Veuillez l'etat de la commande");
        //}
        if (commandeFournisseurDto.getFournisseur() == null || commandeFournisseurDto.getFournisseur().getId() == null) {
            errors.add("Veuillez saisir le fournisseur");
        }

        return errors;
    }
}

package com.pi.gest.validator;

import com.pi.gest.dto.OperationStockDto;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OperationStockValidator {



    public static List<String> validate(OperationStockDto operationStockDto) {
        List<String> errors = new ArrayList<>();
        if (operationStockDto == null) {
            errors.add("date du mouvenent");
            errors.add("quantite du mouvenent");
            errors.add("article");
            errors.add("type du mouvement");

            return errors;
        }
        if (operationStockDto.getDateOperationStock() == null) {
            errors.add("date du mouvenent");
        }
        if (operationStockDto.getQuantite() == null || operationStockDto.getQuantite().compareTo(BigDecimal.ZERO) == 0) {
            errors.add(" quantite du mouvenent");
        }
        if (operationStockDto.getArticle() == null || operationStockDto.getArticle().getId() == null) {
            errors.add("article");
        }
        if (!StringUtils.hasLength(operationStockDto.getTypeOperationStock().name())) {
            errors.add("type du mouvement");
        }

        return errors;
    }
}

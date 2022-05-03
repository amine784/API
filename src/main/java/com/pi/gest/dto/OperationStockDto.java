package com.pi.gest.dto;

import com.pi.gest.model.OperationStock;
import com.pi.gest.model.SourceOperationStock;
import com.pi.gest.model.TypeOperationStock;
import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class OperationStockDto {

    private Integer id;


    private Instant dateOperationStock;
    private BigDecimal quantite;
    private ArticleDto article;

    private TypeOperationStock typeOperationStock;

    private SourceOperationStock sourceOperationStock;

    private Integer idEntreprise;


    public  static OperationStockDto fromEntity(OperationStock operationStock){
        if(operationStock == null){
            return null;
        }

        return OperationStockDto.builder()
                .id(operationStock.getId())
                .dateOperationStock(operationStock.getDateOperationStock())
                .quantite(operationStock.getQuantite())
                .article(ArticleDto.fromEntity(operationStock.getArticle()))
                .typeOperationStock(operationStock.getTypeOperationStock())
                .sourceOperationStock(operationStock.getSourceOperationStock())
                .idEntreprise(operationStock.getIdEntreprise())
                .build();


    }
    public  static OperationStock toEntity(OperationStockDto operationStockDto){
        if(operationStockDto == null){
            return null;
        }
        OperationStock operationStock = new OperationStock();
        operationStock.setId(operationStockDto.getId());
        operationStock.setDateOperationStock(operationStockDto.getDateOperationStock());
        operationStock.setQuantite(operationStock.getQuantite());
        operationStock.setArticle(ArticleDto.toEntity(operationStockDto.getArticle()));
        operationStock.setTypeOperationStock(operationStockDto.getTypeOperationStock());
        operationStock.setSourceOperationStock(operationStock.getSourceOperationStock());
        operationStock.setIdEntreprise(operationStock.getIdEntreprise());

        return operationStock;
    }

}

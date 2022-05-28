package com.pi.gest.services;

import com.pi.gest.dto.OperationStockDto;

import java.math.BigDecimal;
import java.util.List;

public interface OperationStockService {



    BigDecimal stockReelArticle(Integer idArticle);

    List<OperationStockDto> OperationStockArticle(Integer idArticle);
    OperationStockDto entreeStock(OperationStockDto dto);
    OperationStockDto sortieStock(OperationStockDto dto);
    OperationStockDto correctionStockPos(OperationStockDto dto);
    OperationStockDto correctionStockNeg(OperationStockDto dto);
}

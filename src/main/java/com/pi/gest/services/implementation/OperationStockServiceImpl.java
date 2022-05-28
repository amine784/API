package com.pi.gest.services.implementation;

import com.pi.gest.dto.OperationStockDto;
import com.pi.gest.exception.Errors;
import com.pi.gest.exception.InvalidEntityException;
import com.pi.gest.model.TypeOperationStock;
import com.pi.gest.repository.OperationStockRepository;
import com.pi.gest.services.ArticleService;
import com.pi.gest.services.OperationStockService;
import com.pi.gest.validator.OperationStockValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class OperationStockServiceImpl implements OperationStockService {

    private OperationStockRepository repository;
    private ArticleService articleService;

    @Autowired
    public OperationStockServiceImpl(OperationStockRepository repository, ArticleService articleService) {
        this.repository = repository;
        this.articleService = articleService;
    }



    @Override
    public BigDecimal stockReelArticle(Integer idArticle) {
        if (idArticle == null) {
            log.warn("ID article is NULL");
            return BigDecimal.valueOf(-1);
        }
        articleService.findById(idArticle);
        return repository.stockReelArticle(idArticle);
    }

    @Override
    public List<OperationStockDto> OperationStockArticle(Integer idArticle) {
        return repository.findAllByArticleId(idArticle).stream().map(OperationStockDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public OperationStockDto entreeStock(OperationStockDto dto) {
        return entreePositive(dto, TypeOperationStock.ENTREE);
    }

    @Override
    public OperationStockDto sortieStock(OperationStockDto dto) {
        return sortieNegative(dto, TypeOperationStock.SORTIE);
    }

    @Override
    public OperationStockDto correctionStockPos(OperationStockDto dto) {
        return entreePositive(dto, TypeOperationStock.CORRECTION_POS);
    }

    @Override
    public OperationStockDto correctionStockNeg(OperationStockDto dto) {
        return sortieNegative(dto, TypeOperationStock.CORRECTION_NEG);
    }


    private OperationStockDto entreePositive(OperationStockDto dto, TypeOperationStock typeOperationStock) {
        List<String> errors = OperationStockValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", dto);
            throw new InvalidEntityException("Le mouvement du stock n'est pas valide", Errors.MVT_STK_NOT_VALID, errors);
        }
        dto.setQuantite(
                BigDecimal.valueOf(
                        Math.abs(dto.getQuantite().doubleValue())
                )
        );
        dto.setTypeOperationStock(typeOperationStock);
        return OperationStockDto.fromEntity(
                repository.save(OperationStockDto.toEntity(dto))
        );
    }




        private OperationStockDto sortieNegative(OperationStockDto dto, TypeOperationStock typeOperationStock) {
        List<String> errors = OperationStockValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Article is not valid {}", dto);
            throw new InvalidEntityException("Le mouvement du stock n'est pas valide", Errors.MVT_STK_NOT_VALID, errors);
        }
        dto.setQuantite(
                BigDecimal.valueOf(
                        Math.abs(dto.getQuantite().doubleValue()) * -1
                )
        );
        dto.setTypeOperationStock(typeOperationStock);
        return OperationStockDto.fromEntity(
                repository.save(OperationStockDto.toEntity(dto))
        );
    }
}

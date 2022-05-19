package com.pi.gest.repository;

import com.pi.gest.model.OperationStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface OperationStockRepository extends JpaRepository <OperationStock, Integer > {



   // @Query("select sum(m.quantite) from OperationStock m where m.article.id = :idArticle")
    //BigDecimal stockReelArticle(@Param("idArticle") Integer idArticle);

    //List<OperationStock> findAllByArticleId(Integer idArticle);
}

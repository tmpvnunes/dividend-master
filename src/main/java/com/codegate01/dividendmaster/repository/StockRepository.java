package com.codegate01.dividendmaster.repository;

import com.codegate01.dividendmaster.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    Optional<Stock> findStockByTicker(String stock);

    @Transactional
    Optional<Stock> deleteStockByTicker(String ticker);

    @Transactional
    @Modifying
    @Query("UPDATE Stock s SET s.dividendYield = :dividendYield, s.exDividend = :exDividend, s.lastDividend =:lastDividend WHERE s.stockId = :id")
    public void updateStockDetails(@Param(value = "id") Long id, @Param(value = "dividendYield") double dividendYield, @Param(value="exDividend") Date exDividend, @Param(value ="lastDividend") Date lastDividend);

}

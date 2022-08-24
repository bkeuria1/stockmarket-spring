package com.project.springboot.repo;

import com.project.springboot.entities.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TradeRepo extends JpaRepository<Trade,Integer> {
    List<Trade>findByTicker(String ticker);
//    SELECT
//            (SELECT COUNT(*) FROM ... WHERE ...)
////            - (SELECT COUNT(*) FROM ... WHERE ...) AS Difference
    @Query(value = "select(select SUM(shares) from trades where ticker =:ticker and buying = TRUE) - (select SUM(shares) from trades where ticker =:ticker and buying = FALSE)", nativeQuery = true)
    int getCurrentAmountShares(@Param("ticker") String ticker);

    @Query(value = "select(select SUM(price*shares) from trades where ticker =:ticker and buying = TRUE) - (select SUM(price*shares) from trades where ticker =:ticker and buying = FALSE)", nativeQuery = true)
    float getStockValue(@Param("ticker") String ticker);

    @Query(value = "select distinct ticker from trades", nativeQuery = true)
    List<String>getAllTickers();




}

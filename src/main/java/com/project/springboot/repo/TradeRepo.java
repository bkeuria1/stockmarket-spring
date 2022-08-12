package com.project.springboot.repo;

import com.project.springboot.entities.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TradeRepo extends JpaRepository<Trade,Integer> {
    List<Trade>findByTicker(String ticker);
}

package com.example.trading_system_server.repository;

import com.example.trading_system_server.model.PurchaseLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseLogRepository extends JpaRepository<PurchaseLog,Integer> {

}

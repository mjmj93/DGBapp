package com.example.trading_system_server.repository;

import com.example.trading_system_server.model.Item;
import com.example.trading_system_server.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store,Integer> {
	List<Store> findBySectorId(Integer sectorId);
}

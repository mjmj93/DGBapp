package com.example.trading_system_server.repository;

import com.example.trading_system_server.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {
	List<Item> findByStoreId(Integer storeId);
}

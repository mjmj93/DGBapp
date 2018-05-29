package com.example.trading_system_server.service;

import com.example.trading_system_server.exception.DuplicateUserIdException;
import com.example.trading_system_server.model.Account;
import com.example.trading_system_server.model.Store;
import com.example.trading_system_server.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
	@Autowired
	private StoreRepository storeRepository;

	public List<Store> findBySectorId(Integer sectorId){
		return storeRepository.findBySectorId(sectorId);
	}

	public Store save(Store store) {
		return storeRepository.save(store);
	}

	public List<Store> findAll(){
		return storeRepository.findAll();
	}


}

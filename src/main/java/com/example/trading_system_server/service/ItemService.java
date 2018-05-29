package com.example.trading_system_server.service;

import com.example.trading_system_server.model.Item;
import com.example.trading_system_server.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service

public class ItemService {
	@Autowired
	private ItemRepository itemRepository;

	//	GET: /apis/moments?accountId=xxx
	//	storeId로 item 조회
	public List<Item> findByStoreId(Integer storeId){
		return itemRepository.findByStoreId(storeId);
	}


}

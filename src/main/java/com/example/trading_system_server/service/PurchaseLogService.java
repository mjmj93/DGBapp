package com.example.trading_system_server.service;

import com.example.trading_system_server.model.Item;
import com.example.trading_system_server.model.PurchaseLog;
import com.example.trading_system_server.model.PurchasedItem;
import com.example.trading_system_server.model.dto.PurchasedItemDto;
import com.example.trading_system_server.repository.PurchaseLogRepository;
import com.example.trading_system_server.repository.PurchasedItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PurchaseLogService {
	@Autowired
	private PurchaseLogRepository purchaseLogRepository;

	private PurchasedItemRepository purchasedItemRepository;
//	public List<Item> findByAccountId(Integer accountId){
//		return purchaseLogRepository.findByAccountId(accountId);
//	}

	public Integer save(PurchasedItemDto purchasedItemDto) {
	Integer accountId = purchasedItemDto.getAccountId();
	List<PurchasedItem> items = purchasedItemDto.getItems();
	// 1. 새로운 purchase log 1개 new PurchaseLog 생성 및 저장
	// 2. items for loop 돌면서 new PurchasedItem에 각각 purchase log id랑 item id 채워서 저장

	//저장된 결과의 반환값인 아이디가 들어간다
	PurchaseLog purchaseLog = purchaseLogRepository.save(new PurchaseLog(accountId));

	for (int i = 0;i < items.size(); i++){
		PurchasedItem purchasedItem = items.get(i);
		purchasedItem = new PurchasedItem(purchaseLog.getId(),purchasedItem.getAmount(),purchasedItem.getItem());
		purchasedItemRepository.save(purchasedItem);
	}
	return purchaseLog.getId();
	}
}

package com.example.trading_system_server.service;

import com.example.trading_system_server.model.PurchaseLog;
import com.example.trading_system_server.model.PurchasedItem;
import com.example.trading_system_server.model.dto.PurchasedItemDto;
import com.example.trading_system_server.repository.PurchaseLogRepository;
import com.example.trading_system_server.repository.PurchasedItemRepository;
import lombok.experimental.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class PurchasedItemService {
	@Autowired
	private PurchasedItemRepository purchasedItemRepository;

	@Autowired
	private PurchaseLogRepository purchaseLogRepository;

	@Autowired
	private PurchaseLogService purchaseLogService;
	public boolean receipt(Integer  purchaseLogId, Integer amount, Integer itemId) {
		//receiptState 0 : every items are not receipt yet.
		//receiptState 1 : all items are receipted.
		//receiptState 2 : some items are receipted.

		Integer receiptState = 0;
		Integer prevAmount = purchasedItemRepository.findByPurchaseLogIdAndItemId(purchaseLogId,itemId).getAmount();

		if(amount == prevAmount)
			receiptState = 1;
		else if((amount < prevAmount) && (amount > 0))
			receiptState = 2;
		else
			//in case of received amount is greater than database amount
			//it should be checked at client side
			return false;

		purchasedItemRepository.updateReceiptStatusByPurchaseLogIdAndItemId(receiptState,purchaseLogId, itemId);
		return true;
	}

	public List<PurchasedItem> findByPurchaseLogId (Integer purchaseLogId){
		return purchasedItemRepository.findByPurchaseLogId(purchaseLogId);
	}

}





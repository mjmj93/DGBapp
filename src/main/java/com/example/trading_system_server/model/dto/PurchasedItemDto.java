package com.example.trading_system_server.model.dto;

import com.example.trading_system_server.model.PurchasedItem;
import lombok.Data;

import java.util.List;

@Data
public class PurchasedItemDto {
	private Integer accountId;
	private Integer storeId;
	private List<PurchasedItem> items;

	public PurchasedItemDto(Integer accountId, List<PurchasedItem> items) {
		this.accountId = accountId;
		this.items = items;
	}
}

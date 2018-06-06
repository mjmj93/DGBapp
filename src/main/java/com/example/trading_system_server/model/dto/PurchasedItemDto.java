package com.example.trading_system_server.model.dto;

import com.example.trading_system_server.model.Item;
import com.example.trading_system_server.model.PurchasedItem;
import lombok.Data;

import java.util.List;

@Data
public class PurchasedItemDto {
	private Item item;
	private Integer amount;

	public PurchasedItemDto(Item item, Integer amount) {
		this.amount = amount;
		this.item = item;
	}
}

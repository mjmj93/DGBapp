package com.example.trading_system_server.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PurchasedItem {
	@Id
	@GeneratedValue
	private Integer id;

	private Integer receiptStatus;

	@Column(name = "purchase_log_id")
	private Integer purchaseLogId;

	private Integer amount;

	@ManyToOne
	@JoinColumn(name = "item_id", nullable = false)
	private Item item;

	public PurchasedItem(Integer purchaseLogId, Integer amount, Item item) {
		this.receiptStatus = 0;
		this.purchaseLogId = purchaseLogId;
		this.amount = amount;
		this.item = item;
	}
}

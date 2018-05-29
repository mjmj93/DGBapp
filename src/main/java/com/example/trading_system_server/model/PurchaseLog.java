package com.example.trading_system_server.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class PurchaseLog {
	@Id // primary key
	@GeneratedValue
	private Integer id;

	private String time;

	@Column(nullable = false)
	private Integer accountId;

	@OneToMany
	@JoinColumn(name = "purchase_log_id")
	private List<PurchasedItem> purchasedItemList;

	public PurchaseLog(Integer accountId){
		this.accountId = accountId;
	}

}

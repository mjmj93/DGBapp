package com.example.trading_system_server.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Item {
	@Id // primary key
	@GeneratedValue
	private Integer id;

	private String name;

	//이거 어떻게 처리하나
	private String photo;

	private Integer price;

	private String description;

	@Column(nullable = false)
	private Integer storeId;
}

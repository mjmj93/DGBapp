package com.example.trading_system_server.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Store {
	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	private Integer waitingAmount;

	private String description;


	@Column(nullable = false)
	private Integer sectorId;
}

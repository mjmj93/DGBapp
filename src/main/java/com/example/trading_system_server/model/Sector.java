package com.example.trading_system_server.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Sector {
	//name lang cityid
	@Id
	@GeneratedValue
	private Integer id;

	private String name;
}


//비콘에서 위치 어떻게 받아오는지 알아보고 추가
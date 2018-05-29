package com.example.trading_system_server.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


//실행될때 이걸보고 테이블을 만들어준다.
@Entity
@Data
public class Account {
	@Id // primary key
	@GeneratedValue
	private Integer id;


	private String userId;
	private String email;
	private String password;
	private String name;
	private Integer blance;
	private String fcmToken;

}

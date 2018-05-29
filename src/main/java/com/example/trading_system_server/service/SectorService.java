package com.example.trading_system_server.service;

import com.example.trading_system_server.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class SectorService {
	@Autowired
	private SectorRepository sectorRepository;
}

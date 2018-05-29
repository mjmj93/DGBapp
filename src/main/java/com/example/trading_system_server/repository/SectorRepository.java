package com.example.trading_system_server.repository;

import com.example.trading_system_server.model.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Integer> {
}

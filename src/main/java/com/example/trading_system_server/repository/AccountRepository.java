package com.example.trading_system_server.repository;

import com.example.trading_system_server.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    Account findBySellerFlag(int sellerFlag);
    Account findByEmail(String email);
    Account findByUserId(String userId);
    Account findByUserIdAndPassword(String userId, String password);
    //Account updateAmount(String userId, Integer amount);
}

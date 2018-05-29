package com.example.trading_system_server.repository;

import com.example.trading_system_server.model.PurchasedItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchasedItemRepository extends JpaRepository<PurchasedItem,Integer> {

	// 검색해볼것 "jpql"
	@Query(value = "UPDATE PurchasedItem pi SET pi.receiptStatus = :receiptStatus" +
			" WHERE pi.purchaseLogId = :purchaseLogId AND pi.item.id = :itemId")
	PurchasedItem updateReceiptStatusByPurchaseLogIdAndItemId(@Param("receiptStatus") Integer receiptStatus,
	                                                          @Param("purchaseLogId") Integer purchaseLogId,
	                                                          @Param("itemId") Integer itemId);

	PurchasedItem findByPurchaseLogIdAndItemId(Integer purchaseLogId, Integer itemId);

//	PurchasedItem findByPurchaseLogId()
}

package com.example.trading_system_server.controller;

import com.example.trading_system_server.model.Item;
import com.example.trading_system_server.model.PurchaseLog;
import com.example.trading_system_server.model.PurchasedItem;
import com.example.trading_system_server.model.Store;
import com.example.trading_system_server.model.dto.PurchasedItemDto;
import com.example.trading_system_server.service.ItemService;
import com.example.trading_system_server.service.PurchaseLogService;
import com.example.trading_system_server.service.PurchasedItemService;
import com.example.trading_system_server.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/trading")
public class TradingController {

	@Autowired
	private StoreService storeService;

	@Autowired
	private ItemService itemService;

	@Autowired
	private PurchasedItemService purchasedItemService;

	@Autowired
	private PurchaseLogService purchaseLogService;
	@GetMapping("/store")
	public List<Store> getAllStore() {
		List<Store> stores = new ArrayList<>();
		return stores;
	}

	//현재 위치에서 가까운 가게들
	@GetMapping("/store/{SectorId}")
	public List<Store> getStoresOfSectore(@PathVariable Integer sectoreId){
		List<Store> stores = storeService.findBySectorId(sectoreId);
		return stores;
	}

	@GetMapping("/item/{StoreId}")
	public List<Item> getItemsOfStore(@PathVariable Integer storeId){
		List<Item> items = itemService.findByStoreId(storeId);
		return items;
	}

//	@GetMapping("/item/photo")
//	public Stream<Path> getPhotoOfItem() {
//		return itemService.loadAll();
//	}

	@PostMapping("/purchasedItem")
	public Integer savePurchasedItems(@RequestBody PurchasedItemDto purchasedItemDto){

		return purchaseLogService.save(purchasedItemDto);
	}
//
//	@GetMapping("/{purchaseLodId}")
//	public List<PurchasedItem> GetPurchasedItems(@PathVariable Integer purchaseLogId){
//		List<PurchasedItem> purchasedItems = purchasedItemService.findByPurchaseLogId(purchaseLogId);
//	}
}

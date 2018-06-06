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
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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


	@GetMapping
	private List<Item> getAllAccounts() {
		return itemService.findAll();
	}

	@PostMapping("/addStore")
	public Store addStore(@RequestBody Store store) {
		return storeService.save(store);
	}

	@PostMapping("/addItem")
	public Item addItem(@RequestBody Item item) {
		return itemService.save(item);
	}

	@GetMapping("/store")
	public List<Store> getAllStore() {
		return storeService.findAll();
	}

	@GetMapping("/item")
	public List<Item> getAllItem() {
		return itemService.findAll();
	}

	//현재 위치에서 가까운 가게들
	@GetMapping("/store/{SectorId}")
	public List<Store> getStoresOfSectore(@PathVariable Integer SectoreId){
		List<Store> stores = storeService.findBySectorId(SectoreId);
		return stores;
	}

	@GetMapping("/item/{StoreId}")
	public List<Item> getItemsOfStore(@PathVariable Integer StoreId){
		return itemService.findByStoreId(StoreId);
	}

	// 구매버튼 눌렀을때
	@PostMapping("/purchasedItem/{accountId}/{StoreId}")
	public Integer savePurchasedItems(@PathVariable Integer AccountId,
	                                  @PathVariable Integer StoreId,
	                                  @RequestBody List<PurchasedItemDto> purchasedItemDtos){
		return purchaseLogService.buy(AccountId,StoreId,purchasedItemDtos);
	}

	@GetMapping("/{accountId}")
	public List<PurchasedItem> GetPurchasedItems(@PathVariable Integer accountId){
		return purchasedItemService.findByPurchaseLogId(accountId);
	}

	@GetMapping("/files/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

		Resource file = (Resource) itemService.loadAsResource(filename);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}
}

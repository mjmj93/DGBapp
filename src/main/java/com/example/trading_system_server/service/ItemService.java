package com.example.trading_system_server.service;

import com.example.trading_system_server.exception.DuplicateUserIdException;
import com.example.trading_system_server.model.Account;
import com.example.trading_system_server.model.Item;
import com.example.trading_system_server.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service

public class ItemService {
	@Autowired
	private ItemRepository itemRepository;

	private final Path rootLocation = Paths.get("/Users/minjae/Desktop/servertest");

	//	GET: /apis/moments?accountId=xxx
	//	storeId로 item 조회
	public List<Item> findByStoreId(Integer storeId){
		return itemRepository.findByStoreId(storeId);
	}

	public List<Item> findAll() {
		return itemRepository.findAll();
	}
	public Item save(Item item) {
		return itemRepository.save(item);
	}


	public Path load(String filename) {
		return rootLocation.resolve(filename);
	}
	public Resource loadAsResource(String filename) {
		try {
			Path file = load(filename);

			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			}
			else {
				System.out.println("Could not read file: " + filename);
//				throw new StorageFileNotFoundException(
//						"Could not read file: " + filename);

			}
		}
		catch (MalformedURLException e) {
			System.out.println("Could not read file: " + filename);
//			throw new StorageFileNotFoundException("Could not read file: " + filename, e);
		}
		return null;
	}

}

package com.example.trading_system_server.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//https://firebase.google.com/docs/cloud-messaging/send-message?hl=ko
@Service
@Slf4j
public class FcmService {

	public void test() throws IOException {
		HttpHeaders headers = new HttpHeaders();
//		String accessToken = getAccessToken();
//		System.out.println(accessToken);

		headers.add("Authorization", "key=kakao talk 에 있음");
		headers.add("Content-Type", "application/json");
		RestTemplate restTemplate = new RestTemplate();

		Map<String, Object> map = new HashMap<>();
		Map<String, String> titleMap = new HashMap<>();
		titleMap.put("title", "TEST TITLE");
		titleMap.put("body", "TEST BODY");
		map.put("notification", titleMap);

		//디바이스 키 추후 디비에 넣어놓고 아이디와 매핑해서 유저아이디로 토큰을 찾아 특정유저에게 보내자
		String tempFcmToken = "cCg5FRX1vGY:APA91bHJL2UUPyWKRhe23X3_LstRaZu9XCZcxIXSVcIONYgmP1ccppSWa3wK-GotKs_yh8ljriZA3q18qBwLQl2bRmiXYxLud3HL0F3e32l5Gv-bnp0Qh-r21YJUp120bt07uNobkp1h";
		map.put("to", tempFcmToken);


		//http통신에 이용되는 request message가 바디에 들어가는거
		HttpEntity<Map> request = new HttpEntity<>(map, headers);
		Map response = restTemplate.postForObject("https://fcm.googleapis.com/fcm/send", request, Map.class);
		log.debug(response.toString());
	}
}

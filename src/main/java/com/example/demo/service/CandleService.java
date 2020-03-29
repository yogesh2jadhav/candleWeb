package com.example.demo.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.CandleDto;
import com.example.demo.dto.TradeHistory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Component
public class CandleService {
	private static final Logger log = LoggerFactory.getLogger(CandleService.class);

	public List<CandleDto> getData(String pair, int maxMin) throws JsonMappingException, JsonProcessingException {
		RestTemplate restTemplate = new RestTemplate();
		String tradeHistory = restTemplate.getForObject(
				"https://public.coindcx.com/market_data/trade_history?pair="+pair+"&limit="+maxMin*60, String.class);
		//				"https://public.coindcx.com/market_data/trade_history?pair=B-BTC_USDT&limit=60", String.class);


		ObjectMapper mapper = new ObjectMapper();
		TradeHistory tradeHistoryArr[] = mapper.readValue(tradeHistory.toLowerCase(), TradeHistory[].class);

		List<TradeHistory> tradeHistoryDto = Arrays.asList(tradeHistoryArr);

		Collections.sort(tradeHistoryDto);
		long test_timestamp = tradeHistoryDto.get(0).getT();
		LocalDateTime triggerTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(test_timestamp),
				TimeZone.getDefault().toZoneId());

		tradeHistoryDto.get(0).setMyTime(triggerTime);
		
		List<CandleDto> myCandleDto=CandelValues.findOCHL(tradeHistoryDto,maxMin);
	//	log.info(tradeHistory);
	//	log.info(tradeHistoryDto.toString());
	//	log.info(myCandleDto.toString());
		
		return myCandleDto;
	}
}

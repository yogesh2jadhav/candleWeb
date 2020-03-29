package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CandleDto;
import com.example.demo.service.CandleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class CandleStick {

	@Autowired
	CandleService candleService;
	
	@RequestMapping(path="/candle/{pair}/{maxMin}")
	public List<CandleDto> getCandleStickData(@PathVariable("pair") String pair,  @PathVariable("maxMin") int maxMin) throws JsonMappingException, JsonProcessingException{
		try {
			List<CandleDto> CandleDtoList = candleService.getData(pair,maxMin);
			return CandleDtoList;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(maxMin +"==="+ pair);
		return null;
		
	}
}

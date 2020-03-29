package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.CandleDto;
import com.example.demo.dto.TradeHistory;

public class CandelValues {

	public static List<CandleDto> findOCHL(List<TradeHistory> tradeHisotoryArr, int maxMin) {
		double highPrice = 0;
		double lowPrice = tradeHisotoryArr.get(0).getP();
		List<CandleDto> candleDtoList = new ArrayList<CandleDto>();

		for (int i = 0; i < maxMin; i++) {
			CandleDto candleDto = new CandleDto();
			for (TradeHistory tradeHistory : tradeHisotoryArr) {

				double currentP = tradeHistory.getP();

				if (new Double(currentP).compareTo(new Double(highPrice)) > 0) {
					highPrice = currentP;
				}
				if (new Double(currentP).compareTo(new Double(lowPrice)) < 0) {
					// System.out.println(currentP+"<"+lowPrice);
					lowPrice = currentP;
				}

				candleDto.setOpenPrice(tradeHisotoryArr.get(0).getP());
				candleDto.setClosePrice(tradeHisotoryArr.get(tradeHisotoryArr.size() - 1).getP());
				candleDto.setHighPrice(highPrice);
				candleDto.setLowPrice(lowPrice);
			}
			candleDtoList.add(candleDto);
		}
		return candleDtoList;
	}
}
 
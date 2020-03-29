package com.example.demo.dto;

public class CandleDto {

	public double openPrice, highPrice, lowPrice, volume, closePrice;
	public long tickerTime;
	public double getOpenPrice() {
		return openPrice;
	}
	public void setOpenPrice(double openPrice) {
		this.openPrice = openPrice;
	}
	public double getHighPrice() {
		return highPrice;
	}
	public void setHighPrice(double highPrice) {
		this.highPrice = highPrice;
	}
	public double getLowPrice() {
		return lowPrice;
	}
	public void setLowPrice(double lowPrice) {
		this.lowPrice = lowPrice;
	}
	public double getVolume() {
		return volume;
	}
	public void setVolume(double volume) {
		this.volume = volume;
	}
	public double getClosePrice() {
		return closePrice;
	}
	public void setClosePrice(double closePrice) {
		this.closePrice = closePrice;
	}
	public long getTickerTime() {
		return tickerTime;
	}
	public void setTickerTime(long tickerTime) {
		this.tickerTime = tickerTime;
	}
	@Override
	public String toString() {
		return "CandleDto [openPrice=" + openPrice + ", highPrice=" + highPrice + ", lowPrice=" + lowPrice + ", volume="
				+ volume + ", closePrice=" + closePrice + ", tickerTime=" + tickerTime + "]";
	}
	
}

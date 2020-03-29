package com.example.demo.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties
public class TradeHistory implements Comparable{

	double p;
	double q;
	String s;
	long t;
	boolean m;
	LocalDateTime myTime;
	
	
	 
	public LocalDateTime getMyTime() {
		return myTime;
	}
	public void setMyTime(LocalDateTime myTime) {
		this.myTime = myTime;
	}
	public double getP() {
		return p;
	}
	public void setP(double p) {
		this.p = p;
	}
	public double getQ() {
		return q;
	}
	public void setQ(double q) {
		this.q = q;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	
	public long getT() {
		return t;
	}
	public void setT(long t) {
		this.t = t;
	}
	public boolean isM() {
		return m;
	}
	public void setM(boolean m) {
		this.m = m;
	}
	@Override
	public String toString() {
		return "TradeHistory [p=" + p + ", q=" + q + ", s=" + s + ", t=" + t + ", m=" + m + ", myTime=" + myTime + "]";
	}
	
	@Override
	public int compareTo(Object tradeHistoryObj) {
        long compareTime=((TradeHistory) tradeHistoryObj).getT();
        return  (int) (this.t-compareTime);
    }
	
	 
	 
	
	
}

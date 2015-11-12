package com.uluru.dao;

public class BetweenStationDao {
	
	private Connection con;
	
	public BetweenStationDao() {
		this.com = getConnection();
	}
	
	private Connection getConnection() {
		return new Connection();
	}
	
	public int getTime(String s1, String s2) {	
		return 0;
	}
	
	public int getFare(String s1, String s2) {
		return -1;
	}
}
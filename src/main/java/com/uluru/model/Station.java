package com.uluru.model;

/**
 * 駅情報を保持するクラス
 * @author imazato
 *
 */
public class Station {

	/**
	 * 駅ID
	 */
	private int id;
	
	/**
	 * 駅名
	 */
	private String name;
	
	/**
	 * 路線ID
	 */
	private int routeId;
	
	/**
	 * 路線名
	 */
	private String routeName;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the routeName
	 */
	public String getRouteName() {
		return routeName;
	}

	/**
	 * @param routeName the routeName to set
	 */
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the routeId
	 */
	public int getRouteId() {
		return routeId;
	}

	/**
	 * @param routeId the routeId to set
	 */
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	@Override
	public boolean equals(Object a) {
		Station other = (Station)a;
		if (this.getId() != other.getId() || this.getRouteId() != other.getRouteId()) {
			return false;
		}
		if (!this.getName().equals(other.getName()) || !this.getRouteName().equals(other.getRouteName())) {
			return false;
		}
		return true;
	}
}
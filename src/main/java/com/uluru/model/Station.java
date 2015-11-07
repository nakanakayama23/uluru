package com.uluru.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 駅情報を保持するクラス
 * @author imazato
 *
 */
@XmlRootElement
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
	@XmlElement
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
	@XmlElement
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
	@XmlElement
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
	@XmlElement
	public int getRouteId() {
		return routeId;
	}

	/**
	 * @param routeId the routeId to set
	 */
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	
}
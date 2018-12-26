package indi.nengz.entity;

import org.springframework.stereotype.Component;

@Component
public class Region {
	private String province;
	private String city;
	private String stationName;
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStation() {
		return stationName;
	}
	public void setStation(String station) {
		this.stationName = station;
	}
	
}

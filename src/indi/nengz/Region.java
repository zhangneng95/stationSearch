package indi.nengz;

import org.springframework.stereotype.Component;

@Component
public class Region {
	private String province;
	private String city;
	private String station;
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
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	
}

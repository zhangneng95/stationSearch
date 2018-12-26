package indi.nengz.entity;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Station {
	private String province;
	private String city;
	private String stationName;
	private String id;
	private String password;

	public Station(String province,String city,String stationName,String id,String password) {
	    this.province = province;
	    this.city = city;
	    this.stationName = stationName;
	    this.id = id;
	    this.password = password;
    }
	
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
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

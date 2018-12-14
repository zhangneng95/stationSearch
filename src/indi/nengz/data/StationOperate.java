package indi.nengz.data;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import indi.nengz.Region;
import indi.nengz.Station;

public class StationOperate {
	
	private ReadWrite rw = new ReadWrite();
	@Autowired
	public String save(Station station) {
		String province = station.getProvince();
		String city = station.getCity();
		String stationName= station.getStationName();
		String id = station.getId();
		String password = station.getPassword();
		String json = rw.getDatafromFile("Json");
		JSONArray jsonArray = new JSONArray().fromObject(json);  
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("province", province);
		jsonObject.put("city", city);
		jsonObject.put("station", stationName);
		jsonObject.put("teamView", id);
		jsonObject.put("password", password);
		for(int i = 0 ; i < jsonArray.size(); i++)
		{
			if(jsonArray.getJSONObject(i).equals(jsonObject))
				return "e";
		}
		jsonArray.add(jsonObject);
		rw.saveDataToFile("Json", jsonArray.toString());
 		return "t";
	}
	
	public String find() {
		String jsonString = null;
		String json = rw.getDatafromFile("Json");
		JSONArray jsonArray = new JSONArray().fromObject(json); 
		jsonString = jsonArray.toString();
		return jsonString;
	}
	
	public Region getRegion(Station station) {
		Region region = new Region();
		region.setCity(station.getCity());
		region.setProvince(station.getProvince());
		region.setStation(station.getStationName());
		return region;
	}
}

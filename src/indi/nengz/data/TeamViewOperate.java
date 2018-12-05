package indi.nengz.data;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import indi.nengz.Region;
import indi.nengz.TeamView;

public class TeamViewOperate {
	
	private ReadWrite rw = new ReadWrite();
	@Autowired
	public String save(TeamView teamview) {
		String province = teamview.getProvince();
		String city = teamview.getCity();
		String station= teamview.getStation();
		String id = teamview.getId();
		String password = teamview.getPassword();
		String json = rw.getDatafromFile("Json");
		JSONArray jsonArray = new JSONArray().fromObject(json);  
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("province", province);
		jsonObject.put("city", city);
		jsonObject.put("station", station);
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
	
	public Region getRegion(TeamView teamview) {
		Region region = new Region();
		region.setCity(teamview.getCity());
		region.setProvince(teamview.getProvince());
		region.setStation(teamview.getStation());
		return region;
	}
}

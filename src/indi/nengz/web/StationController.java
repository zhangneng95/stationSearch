package indi.nengz.web;



import indi.nengz.data.ReadWrite;
import indi.nengz.data.StationOperate;

import indi.nengz.entity.Station;
import indi.nengz.service.StationService;
import indi.nengz.service.impl.StationServiceImpl;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/")
public class StationController {
//	private StationOperate stationOperate = new StationOperate();
//	private ReadWrite readWrite = new ReadWrite();

	@Autowired
	private StationService stationService;
	
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showRegistrationForm() {
        return "add";
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public void addStation(Station station, Model model) {
//		String flag = stationOperate.save(station);
////		if(flag == "t") return "1";
////		else if(flag == "e") return "2";
////		return "0";
		stationService.add(station);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String foundId() {
		return "result";
	}
	
    @RequestMapping(value = "/getRegion", produces="text/html;charset=UTF-8",method = RequestMethod.POST)
    @ResponseBody 
    public String sendStation() {
//        String json = stationOperate.find();
		List<Station> list = new ArrayList<Station>();
		list = stationService.findAllStation();
		String json =null;
		json = new JSONArray().fromObject(list).toString();
		return json;
    }

}

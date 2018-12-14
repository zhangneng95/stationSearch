package indi.nengz.web;



import indi.nengz.Station;
import indi.nengz.data.ReadWrite;
import indi.nengz.data.StationOperate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/")
public class InquireController {
	private StationOperate stationOperate = new StationOperate();
	private ReadWrite readWrite = new ReadWrite();
	
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showRegistrationForm() {
        return "add";
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public String addRegion(Station station, Model model) {
		String flag = stationOperate.save(station);
		if(flag == "t") return "1";
		else if(flag == "e") return "2";
		return "0";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String foundId() {
		return "result";
	}
	
    @RequestMapping(value = "/getRegion", produces="text/html;charset=UTF-8",method = RequestMethod.POST)
    @ResponseBody 
    public String sendRegion() {
        String json = stationOperate.find();
		return json;
    }

}

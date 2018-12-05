package indi.nengz.web;



import indi.nengz.Region;
import indi.nengz.TeamView;
import indi.nengz.data.ReadWrite;
import indi.nengz.data.TeamViewOperate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/")
public class InquireController {
	private TeamViewOperate teamViewOperate = new TeamViewOperate();
	private ReadWrite readWrite = new ReadWrite();
	
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String showRegistrationForm() {
        return "add";
    }
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public String addRegion(TeamView teamView, Model model) {
		String flag = teamViewOperate.save(teamView);
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
        String json = teamViewOperate.find();
		return json;
    }

}

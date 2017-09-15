package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import data.LostTeamDAO;

@Controller
public class LostTeamController {

	@Autowired
	LostTeamDAO dao;
	
	@RequestMapping("team.do")
	public ModelAndView hello() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", dao.getHello());
		return mv;
	}
	
	@RequestMapping(path = "GetTeamByName.do", params = "teamName", method = RequestMethod.POST)
	public ModelAndView getTeamByName(String teamName) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("team", dao.getTeamByName(teamName));
		mv.setViewName("result");
		return mv;
	}
}

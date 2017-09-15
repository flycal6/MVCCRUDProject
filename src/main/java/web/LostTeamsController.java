package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import data.LostTeamDAO;

@Controller
public class LostTeamsController {

	@Autowired
	LostTeamDAO dao;
	
	@RequestMapping("team.do")
	public ModelAndView hello() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("data", dao.getHello());
		return mv;
	}
}

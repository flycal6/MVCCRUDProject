package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import data.LostTeam;
import data.LostTeamDAO;

@Controller
public class LostTeamController {

	@Autowired
	LostTeamDAO dao;
	
	@RequestMapping("home.do")
	public ModelAndView homePage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("teamList", dao.getTeams());
		return mv;
	}
	
	@RequestMapping("addTeam.do")
	public ModelAndView addTeamPage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("teamList", dao.getTeams());
		mv.setViewName("addTeam");
		return mv;
	}
	
	@RequestMapping(path = "GetTeamByName.do", params = "teamName", method = RequestMethod.POST)
	public ModelAndView getTeamByName(String teamName) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("team", dao.getTeamByName(teamName));
		mv.setViewName("result");
		return mv;
	}

	@RequestMapping(path = "GetTeamByName.do", params = "teamName", method = RequestMethod.GET)
	public ModelAndView getClickedTeam(String teamName) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("team", dao.getTeamByName(teamName));
		mv.setViewName("result");
		return mv;
	}
	
	@RequestMapping(path="CreateTeam.do", method=RequestMethod.POST)
	public ModelAndView createTeamRedir(LostTeam team, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		dao.addTeam(team);
		redir.addFlashAttribute("team", team);
		mv.setViewName("redirect:TeamAdded.do");
		return mv;
	}
	
	@RequestMapping(path="TeamAdded.do", method=RequestMethod.GET)
	public ModelAndView teamAdded(LostTeam team) {
		dao.addTeam(team);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		return mv;
	}
}

package web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import data.LostTeam;
import data.LostTeamDAO;

@Controller
@SessionAttributes("team") // Get session for deleting objects for user
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
		mv.setViewName("addTeam");
		return mv;
	}

	@RequestMapping(path = "GetTeamByName.do", params = "teamName", method = RequestMethod.POST)
	public ModelAndView getTeamByName(String teamName) {
		ModelAndView mv = new ModelAndView();
		if (dao.getTeamByName(teamName) != null) {
			mv.addObject("team", dao.getTeamByName(teamName));
			mv.setViewName("result");
		} else {
			mv.setViewName("home");
		}

		return mv;
	}

	@RequestMapping(path = "GetTeamByName.do", params = "teamName", method = RequestMethod.GET)
	public ModelAndView getClickedTeam(String teamName) {
		ModelAndView mv = new ModelAndView();
		if (dao.getTeamByName(teamName) != null) {
			mv.addObject("team", dao.getTeamByName(teamName));
		}
		mv.setViewName("result");
		return mv;
	}

	@RequestMapping(path = "RemoveTeam.do")
	public ModelAndView removeTeam(HttpSession session, RedirectAttributes redir) { // Get the session to get the team
																					// to be removed
		LostTeam team = (LostTeam) session.getAttribute("team"); // cast the session attribute to a LostTeam
		ModelAndView mv = new ModelAndView(); // so it can be removed from the list
		if (team != null) {
//			System.out.println("removing " + team);
			dao.removeTeam(team);
		} else {
			System.err.println("Error deleting, team was null");
		}
		redir.addFlashAttribute("team", team);
		mv.setViewName("redirect:TeamDeleted.do");
		return mv;
	}

	@RequestMapping(path = "TeamDeleted.do", method = RequestMethod.GET)
	public ModelAndView teamDeleted(LostTeam team) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("teamList", dao.getTeams());
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping(path = "CreateTeam.do", method = RequestMethod.POST)
	public ModelAndView createTeamRedir(LostTeam team, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		if (team != null) {
			dao.addTeam(team);
		}
		redir.addFlashAttribute("team", team);
		mv.setViewName("redirect:TeamAdded.do");
		return mv;
	}

	@RequestMapping(path = "TeamAdded.do", method = RequestMethod.GET)
	public ModelAndView teamAdded(LostTeam team) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		return mv;
	}

	@RequestMapping(path = "EditTeam.do")
	public String editTeam(LostTeam team) {
		return "editTeam";
	}

	@RequestMapping(path = "UpdateTeam.do", method = RequestMethod.POST)
	public ModelAndView updateTeam(LostTeam team, RedirectAttributes redir) {
//		LostTeam team = (LostTeam) session.getAttribute("team");
		ModelAndView mv = new ModelAndView();
		if (team != null) {
			dao.updateTeam(team);
		}
		redir.addFlashAttribute("team", team);
		mv.setViewName("redirect:TeamUpdated.do");
		return mv;
	}
	
	@RequestMapping(path = "TeamUpdated.do", method = RequestMethod.GET)
	public ModelAndView teamUpdated(LostTeam team) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		return mv;
	}
	
	@RequestMapping(path="SearchByKeyword.do")
	public ModelAndView searchForTeams(String kw) {
		ModelAndView mv = new ModelAndView();
		if (dao.getTeamByKeyword(kw) != null) {
			mv.addObject("teamList", dao.getTeamByKeyword(kw));
		}
		mv.setViewName("home");
		return mv;
	}
}

package data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

//@Component  commented out to direct controller to new LostTeamDbDAOImpl.java
public class LostTeamDAOImpl implements LostTeamDAO {
	
	@Autowired
	private WebApplicationContext wac;
	
	private static final String FILE_NAME = "/WEB-INF/lostTeams.csv";
	private List<LostTeam> teams = new ArrayList<>();

	/*
	 * The @PostConstruct method is called by Spring after object creation and
	 * dependency injection
	 */
	@PostConstruct
	public void init() {
		System.out.println("in init()");
		// Retrieve an input stream from the servlet context
		// rather than directly from the file system
		try (InputStream is = wac.getServletContext().getResourceAsStream(FILE_NAME);
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {
			String line = buf.readLine();
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(",");
				Integer id = Integer.parseInt(tokens[0]);
				String name = tokens[1];
				Integer firstYear = Integer.parseInt(tokens[2]);
				Integer lastYear = Integer.parseInt(tokens[3]);
				String relocatedTo = tokens[4];
				Integer seasons = Integer.parseInt(tokens[5]);
				String record = tokens[6];
				Double winPercent = Double.parseDouble(tokens[7]);
				Integer playoffs = Integer.parseInt(tokens[8]);
				Integer stanleyCups = Integer.parseInt(tokens[9]);
				String reason = tokens[10];
				String logo = tokens[11];
				teams.add(new LostTeam(id, name, firstYear, lastYear, relocatedTo, seasons, record, winPercent, playoffs, stanleyCups, reason, logo));
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	@Override
	public String homePage() {
		return "Hello";
	}

	@Override
	public LostTeam getTeamByName(String name) {
		LostTeam t = null;
		for (LostTeam team : teams) {
			if (team.getName().toLowerCase().contains(name.toLowerCase())) {
				t = team;
				break;
			} else {
				
			}
		}
		return t;
	}

	@Override
	public List<LostTeam> getTeams() {
		return teams;
	}

	@Override
	public void addTeam(LostTeam team) {
		teams.add(team);
	}

	@Override
	public void removeTeam(LostTeam team) {
		teams.remove(team);
	}

//	@Override
//	public LostTeam updateTeam(LostTeam team) {
//		teams.add(team);
//		return team;
//	}
}

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

@Component
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
				String name = tokens[0];
				String firstYear = tokens[1];
				String lastYear = tokens[2];
				String relocatedTo = tokens[3];
				String seasons = tokens[4];
				String record = tokens[5];
				String winPercent = tokens[6];
				String playoffs = tokens[7];
				String stanleyCups = tokens[8];
				String reason = tokens[9];
				String logo = tokens[10];
				teams.add(new LostTeam(name, firstYear, lastYear, relocatedTo, seasons, record, winPercent, playoffs, stanleyCups, reason, logo));
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
			if (team.getName().equalsIgnoreCase(name)) {
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
}

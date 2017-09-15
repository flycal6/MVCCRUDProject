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
		// Retrieve an input stream from the servlet context
		// rather than directly from the file system
		try (InputStream is = wac.getServletContext().getResourceAsStream(FILE_NAME);
				BufferedReader buf = new BufferedReader(new InputStreamReader(is));) {
			String line = buf.readLine();
			while ((line = buf.readLine()) != null) {
				String[] tokens = line.split(",");
				String name = tokens[1];
				String firstYear = tokens[2];
				String lastYear = tokens[3];
				String relocatedTo = tokens[4];
				String seasons = tokens[5];
				String record = tokens[6];
				String winPercent = tokens[7];
				String playoffs = tokens[8];
				String stanleyCups = tokens[9];
				String reason = tokens[10];
				teams.add(new LostTeam(name, firstYear, lastYear, relocatedTo, seasons, record, winPercent, playoffs, stanleyCups, reason));
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	@Override
	public String getHello() {
		return "Hello";
	}
}

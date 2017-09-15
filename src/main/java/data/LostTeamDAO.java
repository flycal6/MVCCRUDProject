package data;

import java.util.List;

public interface LostTeamDAO {
	String homePage();
	LostTeam getTeamByName(String name);
	List<LostTeam> getTeams();
}

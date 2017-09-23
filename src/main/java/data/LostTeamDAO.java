package data;

import java.util.List;

public interface LostTeamDAO {
	String homePage();
	void addTeam(LostTeam team);
	void removeTeam(LostTeam team);
	LostTeam getTeamByName(String name);
	List<LostTeam> getTeams();
//	LostTeam updateTeam(LostTeam team);
}

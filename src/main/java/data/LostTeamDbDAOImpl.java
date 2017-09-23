package data;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class LostTeamDbDAOImpl implements LostTeamDAO {

	private static String url = "jdbc:mysql://localhost:3306/teamdb";
	private String user = "team";
	private String pass = "Kernut3#";
	
	@Override
	public String homePage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTeam(LostTeam team) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTeam(LostTeam team) {
		// TODO Auto-generated method stub

	}

	@Override
	public LostTeam getTeamByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LostTeam> getTeams() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public LostTeam updateTeam(LostTeam team) {
//		if (team != null) {
//			team.setName(name);
//			team.setFirstYear(firstYear);
//			team.setLastYear(lastYear);
//			team.setRelocatedTo(relocatedTo);
//			team.setSeasons(seasons);
//			team.setRecord(record);
//			team.setWinPercent(winPercent);
//			team.setPlayoffs(playoffs);
//			team.setStanleyCups(stanleyCups);
//			team.setReason(reason);
//			team.setLogo(logo);
//		}
//		return null;
//	}

}

package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class LostTeamDbDAOImpl implements LostTeamDAO {

	private static String url = "jdbc:mysql://localhost:3306/teamdb";
	private String user = "student";
	private String pass = "student";

	public LostTeamDbDAOImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Error loading MySQL Driver!!!");
		}
	}

	@Override
	public String homePage() {
		return "Hello";
	}

	@Override
	public void addTeam(LostTeam team) {

	}

	@Override
	public void removeTeam(LostTeam team) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<LostTeam> getTeamByKeyword(String kw) {
		List<LostTeam> teamList = new ArrayList<>();
//		LostTeam team = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "select " + " id, name, first_year, last_year, relocated_to, seasons, record, win_percentage, "
					+ "playoff_appearances, stanley_cups, reason, logo "
					+ " from teams where name like ? ";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			kw = "%" + kw + "%";
			stmt.setString(1, kw);
//			stmt.setString(2, kw);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt(1);
				String name = rs.getString(2);
				Integer firstYear = rs.getInt(3);
				Integer lastYear = rs.getInt(4);
				String relocatedTo = rs.getString(5);
				Integer seasons = rs.getInt(6);
				String record = rs.getString(7);
				Double winPercent = rs.getDouble(8);
				Integer playoffs = rs.getInt(9);
				Integer stanleyCups = rs.getInt(10);
				String reason = rs.getString(11);
				String logo = rs.getString(12);

				teamList.add(new LostTeam(id, name, firstYear, lastYear, relocatedTo, seasons, record, winPercent,
						playoffs, stanleyCups, reason, logo));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teamList;
	}

	@Override
	public List<LostTeam> getTeams() {
		List<LostTeam> teamList = new ArrayList<>();
		LostTeam team = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "select id, name, first_year, last_year, relocated_to, seasons, record, win_percentage, "
					+ "playoff_appearances, stanley_cups, reason, logo "
					+ " from teams ";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
//			kw = "%" + kw + "%";
//			stmt.setString(1, kw);
//			stmt.setString(2, kw);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt(1);
				String name = rs.getString(2);
				Integer firstYear = rs.getInt(3);
				Integer lastYear = rs.getInt(4);
				String relocatedTo = rs.getString(5);
				Integer seasons = rs.getInt(6);
				String record = rs.getString(7);
				Double winPercent = rs.getDouble(8);
				Integer playoffs = rs.getInt(9);
				Integer stanleyCups = rs.getInt(10);
				String reason = rs.getString(11);
				String logo = rs.getString(12);

				teamList.add(new LostTeam(id, name, firstYear, lastYear, relocatedTo, seasons, record, winPercent,
						playoffs, stanleyCups, reason, logo));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teamList;
	}

	@Override
	public LostTeam getTeamByName(String kw) {
//		List<LostTeam> teamList = new ArrayList<>();
		LostTeam team = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			String sql = "select " + " id, name, first_year, last_year, relocated_to, seasons, record, win_percentage, "
					+ "playoff_appearances, stanley_cups, reason, logo "
					+ " from teams where name like ? ";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			kw = "%" + kw + "%";
			stmt.setString(1, kw);
//			stmt.setString(2, kw);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Integer id = rs.getInt(1);
				String name = rs.getString(2);
				Integer firstYear = rs.getInt(3);
				Integer lastYear = rs.getInt(4);
				String relocatedTo = rs.getString(5);
				Integer seasons = rs.getInt(6);
				String record = rs.getString(7);
				Double winPercent = rs.getDouble(8);
				Integer playoffs = rs.getInt(9);
				Integer stanleyCups = rs.getInt(10);
				String reason = rs.getString(11);
				String logo = rs.getString(12);

				team = (new LostTeam(id, name, firstYear, lastYear, relocatedTo, seasons, record, winPercent,
						playoffs, stanleyCups, reason, logo));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return team;
	}

	// @Override
	// public LostTeam updateTeam(LostTeam team) {
	// if (team != null) {
	// team.setName(name);
	// team.setFirstYear(firstYear);
	// team.setLastYear(lastYear);
	// team.setRelocatedTo(relocatedTo);
	// team.setSeasons(seasons);
	// team.setRecord(record);
	// team.setWinPercent(winPercent);
	// team.setPlayoffs(playoffs);
	// team.setStanleyCups(stanleyCups);
	// team.setReason(reason);
	// team.setLogo(logo);
	// }
	// return null;
	// }

}

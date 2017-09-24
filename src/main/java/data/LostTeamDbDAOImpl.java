package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			conn.setAutoCommit(false);
			String sql = "INSERT INTO teams (name, first_year, last_year, relocated_to, seasons, record, win_percentage, "
					+ "playoff_appearances, stanley_cups, reason, logo ) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, team.getName());
			stmt.setInt(2, team.getFirstYear());
			stmt.setInt(3, team.getLastYear());
			stmt.setString(4, team.getRelocatedTo());
			stmt.setInt(5, (team.getLastYear() - team.getFirstYear()));
			stmt.setString(6, team.getRecord());
			stmt.setDouble(7, team.getWinPercent());
			stmt.setInt(8, team.getPlayoffs());
			stmt.setInt(9, team.getStanleyCups());
			stmt.setString(10, team.getReason());
			stmt.setString(11, team.getLogo());
			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				ResultSet keys = stmt.getGeneratedKeys();
				if (keys.next()) {
					int newTeamId = keys.getInt(1);
					team.setId(newTeamId);
				}
			} else {
				team = null;
			}
			conn.commit(); // COMMIT TRANSACTION
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
		}
	}

	@Override
	public void removeTeam(LostTeam team) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			
			String sql = "DELETE FROM teams WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, team.getId());
			int updateCount = stmt.executeUpdate();
			
			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
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

	 @Override
	 public LostTeam updateTeam(LostTeam team) {
		 Connection conn = null;
			try {
				conn = DriverManager.getConnection(url, user, pass);
				conn.setAutoCommit(false);
				String sql = "UPDATE teams SET name=?, first_year=?, last_year=?, relocated_to=?, seasons=?, "
						+ " record=?, win_percentage=?, playoff_appearances=?, stanley_cups=?, reason=?, logo=? "
						+ " WHERE id = ? ";
				PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, team.getName());
				stmt.setInt(2, team.getFirstYear());
				stmt.setInt(3, team.getLastYear());
				stmt.setString(4, team.getRelocatedTo());
				stmt.setInt(5, (team.getLastYear() - team.getFirstYear()));
				stmt.setString(6, team.getRecord());
				stmt.setDouble(7, team.getWinPercent());
				stmt.setInt(8, team.getPlayoffs());
				stmt.setInt(9, team.getStanleyCups());
				stmt.setString(10, team.getReason());
				stmt.setString(11, team.getLogo());
				stmt.setInt(12, team.getId());
				int updateCount = stmt.executeUpdate();
				
				conn.commit(); // COMMIT TRANSACTION
				stmt.close();
				conn.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
				System.err.println("Error Updating Team");
				if (conn != null) {
					try {
						conn.rollback();
					} catch (SQLException sqle2) {
						System.err.println("Error trying to rollback");
					}
				}
			}
			return team;
	 }

}

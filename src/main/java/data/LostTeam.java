package data;

public class LostTeam {
	private String name;
	private String firstYear;
	private String lastYear;
	private String relocatedTo;
	private String seasons;
	private String record;
	private String winPercent;
	private String playoffs;
	private String stanleyCups;
	private String reason;
	private String logo;
	
	public LostTeam() {
	}

	public LostTeam(String name, String firstYear, String lastYear, String relocatedTo, String seasons, String record,
			String winPercent, String playoffs, String stanleyCups, String reason, String logo) {
		this.name = name;
		this.firstYear = firstYear;
		this.lastYear = lastYear;
		this.relocatedTo = relocatedTo;
		this.seasons = seasons;
		this.record = record;
		this.winPercent = winPercent;
		this.playoffs = playoffs;
		this.stanleyCups = stanleyCups;
		this.reason = reason;
		this.logo = logo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstYear() {
		return firstYear;
	}

	public void setFirstYear(String firstYear) {
		this.firstYear = firstYear;
	}

	public String getLastYear() {
		return lastYear;
	}

	public void setLastYear(String lastYear) {
		this.lastYear = lastYear;
	}

	public String getRelocatedTo() {
		return relocatedTo;
	}

	public void setRelocatedTo(String relocatedTo) {
		this.relocatedTo = relocatedTo;
	}

	public String getSeasons() {
		return seasons;
	}

	public void setSeasons(String seasons) {
		this.seasons = seasons;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public String getWinPercent() {
		return winPercent;
	}

	public void setWinPercent(String winPercent) {
		this.winPercent = winPercent;
	}

	public String getPlayoffs() {
		return playoffs;
	}

	public void setPlayoffs(String playoffs) {
		this.playoffs = playoffs;
	}

	public String getStanleyCups() {
		return stanleyCups;
	}

	public void setStanleyCups(String stanleyCups) {
		this.stanleyCups = stanleyCups;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	
	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LostTeam [name=");
		builder.append(name);
		builder.append(", firstYear=");
		builder.append(firstYear);
		builder.append(", lastYear=");
		builder.append(lastYear);
		builder.append(", relocatedTo=");
		builder.append(relocatedTo);
		builder.append(", seasons=");
		builder.append(seasons);
		builder.append(", record=");
		builder.append(record);
		builder.append(", winPercent=");
		builder.append(winPercent);
		builder.append(", playoffs=");
		builder.append(playoffs);
		builder.append(", stanleyCups=");
		builder.append(stanleyCups);
		builder.append(", reason=");
		builder.append(reason);
		builder.append("]");
		return builder.toString();
	}

	
}

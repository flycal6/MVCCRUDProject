package data;

public class LostTeam {
	private Integer id;
	private String name;
	private Integer firstYear;
	private Integer lastYear;
	private String relocatedTo;
	private Integer seasons;
	private String record;
	private Double winPercent;
	private Integer playoffs;
	private Integer stanleyCups;
	private String reason;
	private String logo;

	public LostTeam() {
	}

	public LostTeam(Integer id, String name, Integer firstYear, Integer lastYear, String relocatedTo, Integer seasons,
			String record, Double winPercent, Integer playoffs, Integer stanleyCups, String reason, String logo) {
		super();
		this.id = id;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFirstYear() {
		return firstYear;
	}

	public void setFirstYear(Integer firstYear) {
		this.firstYear = firstYear;
	}

	public Integer getLastYear() {
		return lastYear;
	}

	public void setLastYear(Integer lastYear) {
		this.lastYear = lastYear;
	}

	public String getRelocatedTo() {
		return relocatedTo;
	}

	public void setRelocatedTo(String relocatedTo) {
		this.relocatedTo = relocatedTo;
	}

	public Integer getSeasons() {
		return seasons;
	}

	public void setSeasons(Integer seasons) {
		this.seasons = seasons;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public Double getWinPercent() {
		return winPercent;
	}

	public void setWinPercent(Double winPercent) {
		this.winPercent = winPercent;
	}

	public Integer getPlayoffs() {
		return playoffs;
	}

	public void setPlayoffs(Integer playoffs) {
		this.playoffs = playoffs;
	}

	public Integer getStanleyCups() {
		return stanleyCups;
	}

	public void setStanleyCups(Integer stanleyCups) {
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
		builder.append("LostTeam [id=");
		builder.append(id);
		builder.append(", name=");
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
		builder.append(", logo=");
		builder.append(logo);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LostTeam other = (LostTeam) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

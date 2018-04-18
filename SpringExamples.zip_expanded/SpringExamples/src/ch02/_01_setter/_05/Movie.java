package ch02._01_setter._05;

public class Movie implements IMovie {
	String title;
	java.util.Date premiere;
	java.sql.Date actionDate;
	java.sql.Time movieRuntime;
	java.sql.Timestamp logtime;
	java.util.Date today;
	
	public Movie() {
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public java.util.Date getPremiere() {
		return premiere;
	}

	public void setPremiere(java.util.Date premiere) {
		this.premiere = premiere;
	}

	public java.sql.Date getActionDate() {
		return actionDate;
	}

	public void setActionDate(java.sql.Date actionDate) {
		this.actionDate = actionDate;
	}

	public java.sql.Time getMovieRuntime() {
		return movieRuntime;
	}

	public void setMovieRuntime(java.sql.Time movieRuntime) {
		this.movieRuntime = movieRuntime;
	}

	public java.sql.Timestamp getLogtime() {
		return logtime;
	}

	public void setLogtime(java.sql.Timestamp logtime) {
		this.logtime = logtime;
	}
	
	public java.util.Date getToday() {
		return today;
	}

	public void setToday(java.util.Date today) {
		this.today = today;
	}

	@Override
	public String getComment() {
		return String.format("片名:%-16s 首印日: %tY年%tm月%td日   "
			+ " 開拍日: %tY年%tm月%td日    片長: %tH時%tM分%tS秒, "
			+ " 登錄日: %tY年%tm月%td日   %tH時%tM分%tS秒  "
			+ " 資料顯示日期: %tY年%tm月%td日  ", 
			title, premiere, premiere, premiere, actionDate, actionDate, actionDate,
			movieRuntime, movieRuntime, movieRuntime, logtime, logtime, logtime, 
			logtime, logtime, logtime, today, today, today
				);
	}
}
//

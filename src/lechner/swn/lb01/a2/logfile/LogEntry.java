package lechner.swn.lb01.a2.logfile;

import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

public class LogEntry {
	public String get_logLine() {
		return _logLine;
	}
	public String get_host() {
		return _host;
	}
	public void set_host(String host) {
		_host = host;
	}
	public String get_identifier() {
		return _identifier;
	}
	public void set_identifier(String identifier) {
		_identifier = identifier;
	}
	public String get_user() {
		return _user;
	}
	public void set_user(String user) {
		_user = user;
	}
	public Date get_time() {
		return _time;
	}
	public void set_time(Date time) {
		_time = time;
	}
	public String get_request() {
		return _request;
	}
	public void set_request(String request) {
		_request = request;
	}
	public int get_statusCode() {
		return _statusCode;
	}
	public void set_statusCode(int statusCode) {
		_statusCode = statusCode;
	}
	public int get_size() {
		return _size;
	}
	public void set_size(int size) {
		_size = size;
	}
	public String get_referrer() {
		return _referrer;
	}
	public void set_referrer(String referrer) {
		_referrer = referrer;
	}
	public String get_userAgent() {
		return _userAgent;
	}
	public void set_userAgent(String userAgent) {
		_userAgent = userAgent;
	}
	
	private String _logLine;
	private String _host="";
	private String _identifier="";
	private String _user = "";
	private Date _time;
	private String _request="";
	private int _statusCode=0;
	private int _size=0;
	private String _referrer="";
	private String _userAgent="";
	
	public LogEntry(String logLine){
		_logLine = logLine;
		
		StringTokenizer matcher = new StringTokenizer(logLine);
		_identifier = matcher.nextToken();

		matcher.nextToken("[");
		String dateString = matcher.nextToken("]").substring(1);
		Calendar c = Calendar.getInstance();
		c.set(Integer.parseInt(dateString.substring(7, 11)), monthToNr(dateString.substring(3, 6)),
		 Integer.parseInt(dateString.substring(0, 2)),Integer.parseInt(dateString.substring(12, 14)),
		 Integer.parseInt(dateString.substring(15, 17)),Integer.parseInt(dateString.substring(18, 20)));
		_time = c.getTime();
		
		matcher.nextToken("\"");
		_request = matcher.nextToken();
		
		matcher.nextToken(" ");
		_statusCode = Integer.parseInt(matcher.nextToken());
		
		_size = Integer.parseInt(matcher.nextToken());
		
		matcher.nextToken("\"");
		_referrer = matcher.nextToken();
		
		matcher.nextToken("\"");
		_userAgent = matcher.nextToken("\"");
	}
	
	private static int monthToNr(String month){
		if (month.equals("Jan")) return 0;
		if (month.equals("Feb")) return 1;
		if (month.equals("Mar")) return 2;
		if (month.equals("Apr")) return 3;
		if (month.equals("May")) return 4;
		if (month.equals("Jun")) return 5;
		if (month.equals("Jul")) return 6;
		if (month.equals("Aug")) return 7;
		if (month.equals("Sep")) return 8;
		if (month.equals("Oct")) return 9;
		if (month.equals("Nov")) return 10;
		return 11;
	}
}

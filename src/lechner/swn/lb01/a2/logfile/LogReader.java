package lechner.swn.lb01.a2.logfile;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class LogReader {
	private ArrayList<LogEntry> logEntries;
	public LogReader(String filePath){
		logEntries = new  ArrayList<LogEntry>();
		try
		{
			FileInputStream fstream = new FileInputStream(filePath);
		    DataInputStream in = new DataInputStream(fstream);
		    BufferedReader br = new BufferedReader(new InputStreamReader(in));
		    
		    String strLine;
		    //Read File Line By Line
		    while ((strLine = br.readLine()) != null)   {
			    // Print the content on the console
			    LogEntry e = new LogEntry(strLine);
			    logEntries.add(e);
		    }
		    //Close the input stream
		    in.close();
	    }
		catch (Exception e){//Catch exception if any
	    	System.err.println("Error: " + e.getMessage());
	    }
		//LogEntry logEntry = new LogEntry("151.48.123.70 - - [08/Dec/2007:00:00:42 -0800] \"GET /css/main.css HTTP/1.1\" 200 7566 \"http://www.smsync.com/order/?ref=002\" \"Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)\" www.smsync.com");
	}
	
	public ArrayList<LogEntry> getLogEntries(){
		return logEntries;
	}
}

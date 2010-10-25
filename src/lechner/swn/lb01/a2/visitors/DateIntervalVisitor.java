/**
 * 
 */
package lechner.swn.lb01.a2.visitors;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

import lechner.swn.lb01.a2.NamedParam;
import lechner.swn.lb01.a2.logfile.LogEntry;

/**
 * @author Mike
 *
 */
public class DateIntervalVisitor implements IVisitor {
	private Date fromDate, toDate;
	
	public DateIntervalVisitor(@NamedParam("From Date") String fromDate, @NamedParam("To Date") String toDate){
		this.fromDate= parseDate(fromDate);
		this.toDate= parseDate(toDate);
	}
	
	private Date parseDate(String dateString){
		Calendar c = Calendar.getInstance();
		String[] values = dateString.split("/");
		c.set(Integer.parseInt(values[0]), Integer.parseInt(values[1])-1, Integer.parseInt(values[2]));
		return c.getTime();
	}
	
	/* (non-Javadoc)
	 * @see lechner.swn.lb01.a2.visitors.IVisitor#apply(java.util.ArrayList)
	 */
	@Override
	public void apply(ArrayList<LogEntry> entries) {
		HashSet<LogEntry> matches = new HashSet<LogEntry>();
		
		for(LogEntry e : entries){
			if(e.get_time().after(fromDate) && e.get_time().before(toDate)){
				matches.add(e);
			}
		}
		
		entries.retainAll(matches);
	}

}

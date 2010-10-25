/**
 * 
 */
package lechner.swn.lb01.a2.visitors;

import java.util.ArrayList;
import java.util.HashSet;

import lechner.swn.lb01.a2.NamedParam;
import lechner.swn.lb01.a2.logfile.LogEntry;

/**
 * @author Mike
 *
 */
public class IPVisitor implements IVisitor {
	private String ip;
	
	public IPVisitor(@NamedParam("IP") String ip){
		this.ip = ip;
	}
	
	/* (non-Javadoc)
	 * @see lechner.swn.lb01.a2.visitors.IVisitor#apply(java.util.ArrayList)
	 */
	@Override
	public void apply(ArrayList<LogEntry> entries) {
		HashSet<LogEntry> matches = new HashSet<LogEntry>();
		for(LogEntry e : entries){
			if(e.get_identifier().equals(ip)){
				matches.add(e);
			}
		}
		
		entries.retainAll(matches);
	}

}

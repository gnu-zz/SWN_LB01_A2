/**
 * 
 */
package lechner.swn.lb01.a2.selectors;

import java.util.ArrayList;

import lechner.swn.lb01.a2.logfile.LogEntry;

/**
 * @author Mike
 *
 */
public class LogEntrySelector implements ISelector {

	/* (non-Javadoc)
	 * @see lechner.swn.lb01.a2.selectors.ISelector#select(java.util.ArrayList)
	 */
	@Override
	public void select(ArrayList<LogEntry> entries) {
		for(LogEntry e : entries){
			System.out.println(e.get_logLine());
		}

	}

}

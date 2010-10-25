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
public class TotalHitsSelector implements ISelector {

	/* (non-Javadoc)
	 * @see lechner.swn.lb01.a2.selectors.ISelector#select(java.util.ArrayList)
	 */
	@Override
	public void select(ArrayList<LogEntry> entries) {
		Integer totalHits = 0;
		if(entries != null){
			totalHits = entries.size();
		}
		
		System.out.println("Total Hits: "+totalHits.toString());

	}

}

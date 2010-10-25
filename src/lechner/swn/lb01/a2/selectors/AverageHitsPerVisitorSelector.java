/**
 * 
 */
package lechner.swn.lb01.a2.selectors;

import java.util.ArrayList;
import java.util.HashSet;

import lechner.swn.lb01.a2.logfile.LogEntry;

/**
 * @author Mike
 *
 */
public class AverageHitsPerVisitorSelector implements ISelector {

	/* (non-Javadoc)
	 * @see lechner.swn.lb01.a2.selectors.ISelector#select(java.util.ArrayList)
	 */
	@Override
	public void select(ArrayList<LogEntry> entries) {
		HashSet<String> visitors = new HashSet<String>();
		
		if(entries == null){
			entries = new ArrayList<LogEntry>();
		}
		
		for(LogEntry e : entries){
			if(!visitors.contains(e.get_identifier())){
				visitors.add(e.get_identifier());
			}
		}
		
		Float avgHits = entries.size() / (float)visitors.size(); 
		System.out.println("Average Hits per Visitor: "+avgHits.toString());
	}

}

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
public class BrowsersSelector implements ISelector {

	/* (non-Javadoc)
	 * @see lechner.swn.lb01.a2.selectors.ISelector#select(java.util.ArrayList)
	 */
	@Override
	public void select(ArrayList<LogEntry> entries) {
		HashSet<String> browsers = new HashSet<String>();
		if(entries == null){
			entries = new ArrayList<LogEntry>();
		}
		
		for(LogEntry e : entries){
			if(!browsers.contains(e.get_userAgent())){
				browsers.add(e.get_userAgent());
			}
		}
		
		for(String s : browsers){
			System.out.println("Browser: "+s);
		}
	}

}

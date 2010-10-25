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
public class PageVisitor implements IVisitor {
	private String page;
	
	public PageVisitor(@NamedParam("Page URL") String page){
		this.page = page;
	}
	
	/* (non-Javadoc)
	 * @see lechner.swn.lb01.a2.visitors.IVisitor#apply(java.util.ArrayList)
	 */
	@Override
	public void apply(ArrayList<LogEntry> entries) {
		HashSet<LogEntry> matches = new HashSet<LogEntry>();
		
		for(LogEntry e : entries){
			String actualPage = e.get_request();
			actualPage = actualPage.substring(actualPage.indexOf(" ")+1);
			if(actualPage.startsWith(page)){
				matches.add(e);
			}
		}
		
		entries.retainAll(matches);
	}

}

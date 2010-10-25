/**
 * 
 */
package lechner.swn.lb01.a2.visitors;

import java.util.ArrayList;

import lechner.swn.lb01.a2.logfile.LogEntry;

/**
 * @author Mike
 *
 */
public interface IVisitor {
	void apply(ArrayList<LogEntry> entries);
}

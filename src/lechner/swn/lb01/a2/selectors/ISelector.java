package lechner.swn.lb01.a2.selectors;

import java.util.ArrayList;

import lechner.swn.lb01.a2.logfile.LogEntry;

public interface ISelector {
	void select(ArrayList<LogEntry> entries);
}

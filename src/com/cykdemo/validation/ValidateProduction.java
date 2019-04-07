package com.cykdemo.validation;

import java.util.HashSet;

public class ValidateProduction {
	private HashSet<NonTerminal>[][] table;
	private boolean isStart = false;
	
	public HashSet<NonTerminal>[][] getTable() {
		return table;
	}
	public void setTable(HashSet<NonTerminal>[][] table) {
		this.table = table;
	}
	public boolean isStart() {
		return isStart;
	}
	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}
}

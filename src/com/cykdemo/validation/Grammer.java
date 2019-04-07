package com.cykdemo.validation;

import java.util.List;

public class Grammer {
 private boolean isValid;
 public boolean isValid() {
	return isValid;
}
public void setValid(boolean isValid) {
	this.isValid = isValid;
}
public Terminal getTerminal() {
	return terminal;
}
public void setTerminal(Terminal terminal) {
	this.terminal = terminal;
}
private Terminal terminal;
}

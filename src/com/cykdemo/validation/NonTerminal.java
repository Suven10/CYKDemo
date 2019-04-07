package com.cykdemo.validation;

public class NonTerminal {

	private String value;
	private boolean isStart = false;

	public NonTerminal(String value) {
		this.value = value;
	}

	public NonTerminal(String value, boolean isStart) {
		this.value = value;
		this.isStart = isStart;
	}

	public String getValue() {
		return value;
	}

	public boolean isStart() {
		return isStart;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NonTerminal other = (NonTerminal) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}


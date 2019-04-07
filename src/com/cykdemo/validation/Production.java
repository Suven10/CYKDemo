package com.cykdemo.validation;


public class Production {

	private NonTerminal left;

	private NonTerminal right1;
	private NonTerminal right2;

	private Terminal right;

	public Production(NonTerminal left, NonTerminal right1, NonTerminal right2) {
		this.left = left;
		this.right1 = right1;
		this.right2 = right2;

	}

	public Production(NonTerminal left, Terminal right) {
		this.left = left;
		this.right = right;
	}

	public NonTerminal getLeft() {
		return left;
	}

	public boolean isProduce(NonTerminal right1, NonTerminal right2) {
		return this.right1 != null && this.right2 != null && this.right1.equals(right1) && this.right2.equals(right2);
	}

	public boolean isProduce(Terminal right) {
		return this.right != null && this.right.equals(right);
	}

}

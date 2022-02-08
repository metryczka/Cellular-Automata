package controller;

public class Rule {

	private int rule;

	public Rule(int rule) {
		this.rule = rule;
	}
	
	public int get (int digit) {
		int value = rule >> digit;
		return value & 1;
	}
	
	public String toString () {
		return String.format("%8s", Integer.toBinaryString(rule)).replace(" ", "0");
	}

}

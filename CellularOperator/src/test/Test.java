package test;

import controller.Rule;

public class Test {

	public static void main (String[] args) {
		Rule rule = new Rule(90);
		System.out.println(rule);
		
		System.out.println(rule.get(7));
	}

}

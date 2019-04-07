package com.cykdemo.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.cykdemo.validation.Grammer;
import com.cykdemo.validation.NonTerminal;
import com.cykdemo.validation.Parser;
import com.cykdemo.validation.Production;
import com.cykdemo.validation.Terminal;

public class CommonWrapper {
	private static List<Terminal> terminals = new ArrayList<Terminal>();
	
//	public List<Terminal> getTerminals() {
//		return terminals;
//	}
//
//	public void setTerminals() {
//		this.terminals = setDefaultTerminals();
//	}

	public static NonTerminal s = new NonTerminal("S",true);
	public static NonTerminal M = new NonTerminal("NP");
	public static NonTerminal W = new NonTerminal("VP");
	public static NonTerminal D = new NonTerminal("Det");
	public static NonTerminal Q = new NonTerminal("PP");
	public static NonTerminal N = new NonTerminal("N");
	public static NonTerminal V = new NonTerminal("V");
	public static NonTerminal P = new NonTerminal("P");
	public static NonTerminal A = new NonTerminal("TEMP1");

	public static Terminal a = new Terminal("a");
	public static Terminal an = new Terminal("an");
	public static Terminal the = new Terminal("the");

	public static Terminal man = new Terminal("man");
	public static Terminal girl = new Terminal("girl");
	public static Terminal dog = new Terminal("dog");
	public static Terminal rat = new Terminal("rat");
	public static Terminal telescope = new Terminal("telescope");

	public static Terminal chased = new Terminal("chased");
	public static Terminal saw = new Terminal("saw");
	public static Terminal barked = new Terminal("barked");
	public static Terminal with = new Terminal("with");
	public static Terminal into = new Terminal("into");
	public static Terminal from = new Terminal("from");
	public static Terminal at = new Terminal("at");

	public static Parser setDefault() {

		Parser grammer = new Parser();
		grammer.setProduction(new Production(s, M, W));

		grammer.setProduction(new Production(W, barked));
		grammer.setProduction(new Production(W, saw));
		grammer.setProduction(new Production(W, chased));
		grammer.setProduction(new Production(W, V, M));
		grammer.setProduction(new Production(W, V, A));

		grammer.setProduction(new Production(P, from));
		grammer.setProduction(new Production(P, with));
		grammer.setProduction(new Production(P, at));
		grammer.setProduction(new Production(P, into));

		grammer.setProduction(new Production(N, telescope));
		grammer.setProduction(new Production(N, dog));
		grammer.setProduction(new Production(N, rat));
		grammer.setProduction(new Production(N, girl));
		grammer.setProduction(new Production(N, man));

		grammer.setProduction(new Production(D, the));
		grammer.setProduction(new Production(D, an));
		grammer.setProduction(new Production(D, a));

		grammer.setProduction(new Production(V, barked));
		grammer.setProduction(new Production(V, chased));
		grammer.setProduction(new Production(V, saw));

		grammer.setProduction(new Production(M, D, N));
		grammer.setProduction(new Production(A, M, Q));
		grammer.setProduction(new Production(Q, P, M));
		return grammer;
	}
	
	public static List<Terminal> setDefaultTerminals() {
		terminals.add(a);
		terminals.add(an);
		terminals.add(the);
		terminals.add(man);
		terminals.add(girl);
		terminals.add(dog);
		terminals.add(rat);
		terminals.add(telescope);
		terminals.add(chased);
		terminals.add(saw);
		terminals.add(barked);
		terminals.add(from);
		terminals.add(with);
		terminals.add(at);
		terminals.add(into);
		return terminals;
	}
	
	public static Grammer checkGrammer(String match) {
		Grammer returnValue =  new Grammer();
		List<Terminal> collect = terminals.stream().filter(t-> t.getValue().equals(match)).collect(Collectors.toList());
		returnValue.setTerminal(collect.stream().findFirst().get());
		returnValue.setValid((!collect.isEmpty()) ? true : false);
		return returnValue;
	}
}

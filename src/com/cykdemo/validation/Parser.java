package com.cykdemo.validation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Parser {
	public Set<Production> productions = new HashSet<>();

	public void setProduction(Production production) {
		productions.add(production);
	}

	public void printCYKMatrix(HashSet<NonTerminal>[][] table) {
		int length = table[0].length;
		for (int i = 0; i < length; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < length - i; j++) {
				for (NonTerminal nonTerminal : table[i][j]) {
					System.out.print(nonTerminal.getValue());
				}
				System.out.print("  ");
			}
			System.out.println("  ");
		}

	}

	private boolean hasStartNonTerminal(HashSet<NonTerminal> lastValue) {
		for (NonTerminal nonTerminals : lastValue) {
			if (nonTerminals.isStart())
				return true;
		}
		return false;
	}

	private HashSet<NonTerminal> getProductionLeftNonTerminal(HashSet<NonTerminal>[][] table, int i, int j) {
		HashSet<NonTerminal> nonTerminals = new HashSet<>();
		for (int x = j; x < i + j; x++) {
			HashSet<NonTerminal> set1 = table[x - j][j];
			HashSet<NonTerminal> set2 = table[i + j - x - 1][x + 1];
			for (NonTerminal right1 : set1) {
				for (NonTerminal right2 : set2) {
					nonTerminals.addAll(getProductionLeftNonTerminal(right1, right2));
				}
			}

		}
		return nonTerminals;
	}

	private HashSet<NonTerminal> getProductionLeftNonTerminal(NonTerminal right1, NonTerminal right2) {
		HashSet<NonTerminal> nonTerminals = new HashSet<>();
		for (Production production : productions) {
			if (production.isProduce(right1, right2)) {
				nonTerminals.add(production.getLeft());
			}
		}

		return nonTerminals;

	}

	private HashSet<NonTerminal> getProductionLeftNonTerminal(Terminal right) {
		HashSet<NonTerminal> nonTerminals = new HashSet<>();
		for (Production production : productions) {
			if (production.isProduce(right)) {
				nonTerminals.add(production.getLeft());
			}
		}
		return nonTerminals;
	}

	@SuppressWarnings("unchecked")
	public ValidateProduction validateSentence(List<Terminal> terminals) {
		int length = terminals.size();
		
		ValidateProduction returnValue = new ValidateProduction();
		
		HashSet<NonTerminal>[][] table = new HashSet[length][length];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < (length - i); j++) {
				if (i > 0) {
					table[i][j] = getProductionLeftNonTerminal(table, i, j);
				} else {
					table[0][j] = getProductionLeftNonTerminal(terminals.get(j));
				}
			}
		}
		returnValue.setStart(hasStartNonTerminal(table[length - 1][0]));
		returnValue.setTable(table);
		return returnValue;
	}
}

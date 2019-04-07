package com.cykdemo.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.cykdemo.helpers.CommonWrapper;
import com.cykdemo.validation.Grammer;
import com.cykdemo.validation.Parser;
import com.cykdemo.validation.Terminal;
import com.cykdemo.validation.ValidateProduction;

public class CYKDemoMain {

	public static void main(String[] args) {
		List<Terminal> validTerminals = new ArrayList<Terminal>();
		CommonWrapper.setDefaultTerminals();
		System.out.println( "Enter a sentence with following preposition : ");
		System.out.println( "an,a,the,man,girl,dog,rat,telescope,chased,saw,barked,with,into,from,at");
		Scanner scanner = new Scanner(System.in);
		String[] sentence = scanner.nextLine().split(" ");
		boolean isValidGrammer = false;
		for (String word : sentence) {
			Grammer grammer = CommonWrapper.checkGrammer(word);
			isValidGrammer = grammer.isValid();
			if(!isValidGrammer)
				break;
			else
				validTerminals.add(grammer.getTerminal());
		}
		scanner.close();
		if(isValidGrammer) {
			Parser initializeGrammer = CommonWrapper.setDefault();
			ValidateProduction validateProd = initializeGrammer.validateSentence(validTerminals);
			initializeGrammer.printCYKMatrix(validateProd.getTable());
			boolean isValid = validateProd.isStart();
			System.out.println();
			System.out.print("Result:");
			System.out.println(isValid ? "Sentence provided is valid" : "Sentence provided is not valid");
			System.out.println();
			
//			validateProd = initializeGrammer.validateSentence(Arrays.asList(CommonWrapper.a, CommonWrapper.man, CommonWrapper.chased, CommonWrapper.a, CommonWrapper.dog, CommonWrapper.with, CommonWrapper.a, CommonWrapper.telescope));
//			initializeGrammer.printCYKMatrix(validateProd.getTable());
//			isValid = validateProd.isStart();
//			System.out.println();
//			System.out.print("Result:");
//			System.out.println(isValid ? "Sentence provided is valid" : "Sentence provided is not valid");
//			System.out.println();
		}
		else {
			System.out.println("Sentence does not match the provided preposition");
		}
	}

}

package com.saurabh.leetcode;

/**
 * Question 1 — Simple Chemical Formula Evaluation
 * 
 * Write a function:
 * 
 * calculateWeight(String formula)
 * 
 * Requirements:
 * 
 * Supported elements:
 * 
 * C → 12
 *  H → 1
 *   O → 8
 *   No parentheses
 * 
 * Single-digit multipliers only
 * 
 * Example:
 * 
 * Input: CH4
 * 
 * Output: 16
 * 
 * Explanation: C = 12 H4 = 1 × 4 = 4 Total = 16
 **/
public class ChemicalFormulaEval {
	
	 public static int calculateWeight(String formula) {
	        // Stores final molecular weight
	        int totalWeight = 0;

	        // Traverse formula one character at a time
	        for (int i = 0; i < formula.length(); i++) {

	            // Current element
	            char element = formula.charAt(i);
	            // Weight of current element
	            int elementWeight = 0;

	            // Determine atomic weight
	            if (element == 'C') {
	                elementWeight = 12;
	            } else if (element == 'H') {
	                elementWeight = 1;
	            } else if (element == 'O') {
	                elementWeight = 8;
	            }
	            // Default multiplier is 1
	            int multiplier = 1;

	            // Check whether next character exists
	            if (i + 1 < formula.length()
	                    && Character.isDigit(formula.charAt(i + 1))) {

	                // Convert character digit to integer
	                multiplier = formula.charAt(i + 1) - '0';

	                // Skip digit because we've already processed it
	                i++;
	            }
	            // Add contribution of current element
	            totalWeight += elementWeight * multiplier;
	        }
	        return totalWeight;
	    }

	
	public static void main(String[] args) {

        System.out.println(calculateWeight("CH4"));      // 16
        System.out.println(calculateWeight("C2H5O2"));   // 45
        System.out.println(calculateWeight("O2"));       // 16
    }

}

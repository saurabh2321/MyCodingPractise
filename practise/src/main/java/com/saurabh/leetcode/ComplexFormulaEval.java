package com.saurabh.leetcode;

import java.util.Stack;

/**
 * Question 2 — Complex Chemical Formula Evaluation

Enhancement over previous problem:
 * C → 12
 *  H → 1
 *   O → 8
Nested parentheses supported
Multipliers after parentheses apply to entire group
Examples:

Input:
H(CH4)2

Output:
33

Input:
((CH4))

Output:
16
 */
public class ComplexFormulaEval {
    public static int calculateWeight(String formula) {

        // Stores weights before entering a group
        Stack<Integer> stack = new Stack<>();

        // Current group's weight
        int currentWeight = 0;

        for (int i = 0; i < formula.length(); i++) {

            char ch = formula.charAt(i);
            // Element encountered
             if (ch == 'C' || ch == 'H' || ch == 'O') {
                int elementWeight = 0;

                if (ch == 'C') {
                    elementWeight = 12;
                } else if (ch == 'H') {
                    elementWeight = 1;
                } else {
                    elementWeight = 8;
                }
                int multiplier = 1;

                // Check element count
                if (i + 1 < formula.length()
                        && Character.isDigit(formula.charAt(i + 1))) {

                    multiplier = formula.charAt(i + 1) - '0';

                    // Skip digit
                    i++;
                }
                currentWeight += elementWeight * multiplier;
            }
            // Opening parenthesis
            else if (ch == '(') {
                // Save current level
                stack.push(currentWeight);

                // Start new group
                currentWeight = 0;
            }
            // Closing parenthesis
            else if (ch == ')') {

                // Weight of completed group
                int groupWeight = currentWeight;
                // Default multiplier
                int multiplier = 1;
                // Check if multiplier exists
                if (i + 1 < formula.length()
                        && Character.isDigit(formula.charAt(i + 1))) {

                    multiplier = formula.charAt(i + 1) - '0';

                    // Skip multiplier
                    i++;
                }
                // Parent group's weight
                int parentWeight = stack.pop();

                // Merge back
                currentWeight =
                        parentWeight + groupWeight * multiplier;
            }
        }
        return currentWeight;
    }
    
	    public static void main(String[] args) {

	        System.out.println(calculateWeight("H(CH4)2")); //33
	        System.out.println(calculateWeight("((CH4))")); //16
	        System.out.println(calculateWeight("(CH4)3")); //48
	    }
}

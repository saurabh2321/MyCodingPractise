package com.saurabh.leetcode;

import java.util.Stack;

public class ValidParenthesis {
	
    public boolean isValid(String s) {
        Stack<Character>  stack = new Stack<>();
        for(char c : s.toCharArray()) {
            
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else if(c == ')' && !stack.empty() && stack.peek() == '(')
                stack.pop();
            else if(c == '}' && !stack.empty() && stack.peek() == '{')
                stack.pop();
              else if(c == ']' && !stack.empty() && stack.peek() == '[')
                stack.pop();
            else 
                return false;
        }
        return stack.empty();
        
    }
    
    public static void main(String[] args) {
    	String s = "({})";
    	ValidParenthesis ValidParenthesis = new ValidParenthesis();
		System.out.println(ValidParenthesis.isValid(s));
		
	}

}

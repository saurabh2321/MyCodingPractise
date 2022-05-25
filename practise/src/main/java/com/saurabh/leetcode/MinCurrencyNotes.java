package com.saurabh.leetcode;

import java.util.Arrays;
import java.util.Collections;

public class MinCurrencyNotes {
	
	public static int getMinNotes(Integer[] currency, int amount) {
		//currency = Arrays.stream(currency).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
		Arrays.sort(currency, Collections.reverseOrder());
		int [] notes  = new int[currency.length];
		int minNotes = 0;
		for(int i=0; i<currency.length; i++) {
			if(amount >= currency[i]) {
				notes[i] = amount/currency[i];
				amount = amount - notes[i] * currency[i];
				
			}
		}
		for(int note:notes) {
			if(note != 0)
				minNotes = minNotes + note;
		}
		return minNotes;
	}
	
	public static void main(String args[]) {
		
		System.out.println(getMinNotes(new Integer[] {200,500,100,50}, 950));
	}

}

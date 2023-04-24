package week4.day1;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class PrintUniqueCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//PrintUniqueCharacter
		/*
		 * Problem
		 * 
		 * a) Take your name as input
		 * b) Print all unique characters only (any order)
		 * 
		 * Input:  babu
		 * Output: a u 
		 * 
		 */

		/*
		 * Psuedocode
		 * 
		 * a) Convert String to Character array
		 * b) Create a new Set -> HashSet
		 * c) Add each character to the Set and if it is already there, remove it
		 * d) Finally, print the set
		 * 
		 */

		String name="ssupriyyya";
		char[] charArray = name.toCharArray();
		Set<Character> set=new LinkedHashSet<Character>();
		Set<Character> dups=new LinkedHashSet<Character>();
		for (Character character : charArray) {
			if(!set.add(character))
				dups.add(character);			
		}
		set.removeAll(dups);
		System.out.println("Unique characters in string "+name+" are "+set);
		

	}


}



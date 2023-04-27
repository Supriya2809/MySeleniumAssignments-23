package week4.day1;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {

	public static void main(String[] args) {

		/*
		 * Problem 
		 * 
		 * There will be running number between 1 to 10
		 * One of the unique number will be missing
		 * Find the missing number
		 * 
		 * 
		 */
		
		/*
		 * Psuedocode
		 * 
		 * a) Remove the duplicates using Set
		 * b) Make sure the set is in the ascending order
		 * c) Iterate from the starting number and verify the next number is + 1
		 * d) If did not match, that is the number
		 * 
		 */
		
		int[] a= {2,5,7,9,1,4,5,8,1,3,4,9,5,3,1,3,7,8};
		Set<Integer> set=new HashSet<Integer>();
		for (int i = 0; i < a.length; i++) {
			set.add(a[i]);
			
		}
		System.out.println(set);
		int i=0,missingnumber=0;
		for (Integer number : set) {
			System.out.println("NUMBER: "+number);
			if(number==i+1)
			{
				System.out.println("number= "+number+" i+1= "+(i+1));
				i++;
				System.out.println("Incrementing I: "+i);
				continue;
			}
			else
			{
				System.out.println("Number Missing.number: "+number+" i+1= "+(i+1));
				missingnumber=i+1;
				break;
			}
			
		}
		System.out.println("Missing Number: "+missingnumber);
		
		
	}

}

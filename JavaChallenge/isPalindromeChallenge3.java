package JavaChallenge;

import java.util.Arrays;

import week3.day2.StringAssignment;

public class isPalindromeChallenge3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sentence="A man, a plan, a canal: Panama";

		isPalindromeChallenge3 objstr=new isPalindromeChallenge3();
		
		objstr.isPalindrome(sentence);
	}

	public void  isPalindrome(String str) {

		//convert all to lower case
		String strlow=str.toLowerCase();
		
		//to character array
		char[] chararry = strlow.toCharArray();
		//temp variable to store only alphabets
		char[] onlyAlphabets=new char[chararry.length];
		int x=0;
		for (int i = 0; i < chararry.length; i++) {
			if((chararry[i]>= 'a' && chararry[i] <= 'z'
					|| chararry[i] >= 'A' && chararry[i] <= 'Z') ) 
			{
				onlyAlphabets[x]=chararry[i];
				x++;
			}
			
		}
		//to print temp array which has only alphabets
		System.out.println("String excluding special characters: ");
		for (int i = 0; i < onlyAlphabets.length; i++) {
			System.out.print(onlyAlphabets[i]);
			
		}
		//temp variable to store reversed string
		String rev="";

		//to iterate through the array and add the last character to temp var
		for (int i =onlyAlphabets.length-1 ; i>=0; i--) {
			rev=onlyAlphabets[i]+rev;

		}
		
		System.out.println("\nReversed String excluding special characters: ");
		char[] revchararray=rev.toCharArray();
		for (int i = 0; i < revchararray.length; i++) {
			System.out.print(revchararray[i]);
		}
		
		System.out.println("\nPALINDROME:");
		//check if both strings are equal
		if(Arrays.equals(onlyAlphabets, revchararray))
			System.out.println("The word "+str+" is a palindrome");
		else
			System.out.println("The word "+str+" is not a palindrome");
		


	}
}

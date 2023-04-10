package week3.day2;

import java.util.Arrays;

public class StringAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringAssignment objstr=new StringAssignment();
		//palindrome
		objstr.isPalindrome();
		//anagram
		objstr.isAnagram();
		//change odd index to upper case
		objstr.changeOddIndexToUpperCase();
		//remove duplicates
		objstr.removeDuplicates();
		//reverse even words
		objstr.reverseEvenWords();
	}
	public void  isPalindrome() {
		
		String word="dig";
		//to character array
		char[] wordToCharArray = word.toCharArray();
		//temp variable to store reversed string
		String rev="";
		
		//to iterate through the array and add the last character to temp var
		for (int i =word.length()-1 ; i>=0; i--) {
			rev=rev+wordToCharArray[i];
			
		}
		
		System.out.println("PALINDROME:");
		//check if both strings are equal
		if(word.equals(rev))
			System.out.println("The word "+word+" is a palindrome");
		else
			System.out.println("The word "+word+" is not a palindrome");
		//System.out.print(rev);
		
		
	}
	@SuppressWarnings("unused")
	public void isAnagram() {
		
		String text1 = "fries";
		String text2 = "fried"; 
		//check string length is equal
		if(text1.length()==text2.length())
		{
			//to char array
			char[] text1ToCharArray = text1.toCharArray();
			char[] text2ToCharArray = text2.toCharArray();
			
			//sort the char arrays
			Arrays.sort(text1ToCharArray);
			Arrays.sort(text2ToCharArray);
			
			//check if the arrays have the same value
			boolean areEqual = org.bouncycastle.util.Arrays.areEqual(text1ToCharArray, text2ToCharArray);
			
			if(areEqual)
			{
				System.out.println("ANAGRAM:");
				System.out.println(text1+" and "+text2+" are anagram");
			}
			else
			{
				System.out.println("ANAGRAM:");
				System.out.println(text1+" and "+text2+" are not anagram");
			}
			
		}
		else
		{
			System.out.println("ANAGRAM:");
		
			System.out.println(text1+" and "+text2+" are not anagram");
		}
		
	}
	public void changeOddIndexToUpperCase() {
		
		String word="hello";
		//to char array
		char[] wordToCharArray = word.toCharArray();
		System.out.println("CHANGE ODD INDEX TO UPPERCASE:");
		//to iterate through the array
		for (int i = 0; i < wordToCharArray.length; i++) {
			
			//to check if the index is odd
			if(i%2 !=0)
				
			{
				//create temp var to store the character
				char a = wordToCharArray[i];
				
				//to change the chrater to upper case
				System.out.print(Character.toUpperCase(a));
			}
			else
				//even index character printed as such
			{
			System.out.print(wordToCharArray[i]);
			}
		}
		System.out.println("\n");
	}
	public void removeDuplicates() {

		String text = "We learn java basics as part of java sessions in java week1";
		int count=0;
		String[] split = text.split(" ");
		String duplicates="",replacementStr;

		for (int i = 0; i < split.length ; i++) {
			//System.out.println("i="+split[i]);
			for (int j = i+1; j < split.length; j++) {
				//System.out.println("j= "+ split[j]);
				if(split[i].equalsIgnoreCase(split[j]))
				{
					count=count+1;
					duplicates=split[j];
					//System.out.println("count: "+count+"duplicate: "+duplicates);
					
				}
				

			}
		}
		//System.out.println(count+duplicates);
		if (count>1) {
			replacementStr = text.replaceAll(duplicates,"");
		}
		else
		{
			replacementStr=text;
		}
		System.out.println("REMOVE DUPLICATE WORDS:");
		System.out.println("Old text with duplicates: "+text+".The new text without duplicates: "+replacementStr+".Duplicate text is "+duplicates+".It has appeared "+count+"times");;

	}
	public void reverseEvenWords() {
		
		String text = "I am a software tester";
		String[] split = text.split(" ");
		System.out.println("REVERSE EVEN WORDS:");
		for (int i = 0; i < split.length; i++) {
			if(i%2!=0) 
			{
				char[] charArray = split[i].toCharArray();
				for (int j = charArray.length-1 ; j >=0 ; j--) 
				{
					System.out.print(charArray[j]);
				}
				System.out.print(" ");
			}
			else 
			{
				System.out.print(split[i]+" ");
			}
		}
	}

}

package week4.day1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		Declare a String as "PayPal India"

		//		Convert it into a character array

		//		Declare a Set as charSet for Character

		//		Declare a Set as dupCharSet for duplicate Character

		//		Iterate character array and add it into charSet

		//		if the character is already in the charSet then, add it to the dupCharSet

		//		Check the dupCharSet elements and remove those in the charSet

		//		Iterate using charSet

		//		Check the iterator variable isn't equals to an empty space

		//		print it

		String str1="PayPal India";
		String str = str1.toLowerCase();
		char[] charArray = str.toCharArray();


		Set<Character> charset=new LinkedHashSet<Character>();
		Set<Character> dupCharSet=new HashSet<Character>();


		for (Character character : charArray) {

			if(!charset.add(character))
			{

				dupCharSet.add(character);
			}

		}

		charset.removeAll(dupCharSet);
		if(charset.contains(' '))
			charset.remove(' ');
		System.out.println("Unique Characters in the string "+str1+" are: "+charset);
		System.out.println("Duplicate Characters are: "+dupCharSet);



	}

}

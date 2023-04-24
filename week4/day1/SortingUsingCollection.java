package week4.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortingUsingCollection {

	public static void main(String[] args) {
		// Declare a String array and add the Strings values as (HCL, Wipro,  Aspire Systems, CTS)		

		// get the length of the array		

		// sort the array			

		// Iterate it in the reverse order

		// print the array
			
		// Required Output: Wipro, HCL , CTS, Aspire Systems
		
		String[] strarr= {"HCL","Wipro","Aspire Systems","CTS"};
		int lengthh=strarr.length;
		List<String> al=Arrays.asList(strarr);
		for (String a : al) {
			System.out.println(a);
		}
		Collections.sort(al, Collections.reverseOrder());
		System.out.println(al);
		

	}

}

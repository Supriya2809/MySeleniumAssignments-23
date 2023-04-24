package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FindSecondLargest {

	public static void main(String[] args) {
		// Here is the input
				int[] data = {3,2,11,4,6,7,2,3,3,6,7};
				//       output= 7;

				/*
				 * Pseudo Code: 
				 * a) Create a empty Set Using TreeSet
				 * b) Declare for loop iterator from 0 to data.length and add into Set 
				 * c) converted Set into List
				 * d) Print the second last element from List
				 * 
				 * 
				 */
				
				Set<Integer> ts1=new TreeSet<Integer>();
				for (int i = 0; i < data.length; i++) {
					ts1.add(data[i]);
					
				}
				System.out.println(ts1);
				List<Integer> al=new ArrayList<Integer>(ts1);
				System.out.println(al);
				System.out.println(al.get(2));
				
	}

}

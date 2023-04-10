package week3.day2;

import java.util.Arrays;
import java.util.Iterator;

public class MissingElementInAnArrayAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {1,2,3,4,7,6,8};
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			//System.out.println(i+arr[i]);
			if (i!=arr[i])
			{
				System.out.println(arr[i]);
				break;
			}
			
			
		}
	}

}

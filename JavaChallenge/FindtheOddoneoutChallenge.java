package JavaChallenge;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ArrayList;

import org.apache.poi.hssf.record.HeaderFooterRecord;

public class FindtheOddoneoutChallenge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 int a[] = {2,1,5,1,5,3,4,4,2};
	        int n = a.length;
	        int k = 2;
	        System.out.println("Unique element in the given array is :"+findOddOneOut(a, n, k));

	}

	public static int findOddOneOut(int a[], int n, int k) {


		int count[] = new int[n];



		for (int i = 0; i < n; i++)
		{
			
			for (int j = 0; j < n; j++)
			{
				
				if ((a[j] & (1 << i)) != 0)
				{

					count[i] += 1;
						
				}

			}
		}

		int unique = 0;
		for (int i = 0; i < n; i++)
			unique += (count[i] % k) * (1 << i);
		unique = unique / (n % k);

		return unique;


	}
}








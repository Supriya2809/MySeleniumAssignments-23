package JavaChallenge;

import java.util.ArrayList;
import java.util.List;

public class FindUniqueChallenege4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {2,3,4,6,4,2,3};
		FindUniqueChallenege4 obj=new FindUniqueChallenege4();
		obj.FindUnique(arr);

	}

	public void FindUnique(int[] num)
	{
		List<Integer> arrList=new ArrayList<Integer>();
		System.out.println("Array List Created"+arrList);
		
		for (int i = 0; i < num.length; i++) {
			arrList.add(num[i]);
			
		}
		System.out.println("Elements added to array list"+arrList);
		List<Integer> dupeList=new ArrayList<Integer>();
		for (int i = 0; i < arrList.size(); i++) {
			for (int j = i+1; j < arrList.size(); j++) {
				if(arrList.get(i)==arrList.get(j))
				{
				  dupeList.add(arrList.get(i))	;
				}
				
			}
		}
		System.out.println("Repeated elements are "+dupeList);
		
		arrList.removeAll(dupeList);
		System.out.println("Unique element in the list is "+arrList);
	}
}

package week1.day2;

public class FibonacciSeries {

	/*
	 * Goal: To find Fibonacci Series for a given range
	 * 
	 * input(range): 8 output: 0, 1, 1, 2, 3, 5, 8, 13
	 * 
	 * Shortcuts: 1) Print : type: syso, followed by: ctrl + space + enter 2) To
	 * create a 'for' loop: type 'for', followed by ctrl + space + down arrow +
	 * enter
	 * 
	 * What are my learnings from this code? 1) 2) 3)
	 * 
	 */

	public static void main(String[] args) {
		int range=8,firstNum=0,secondNum=1,sum=0;
		System.out.println(firstNum+"\n"+secondNum);
		for(int i=2;i<=range;i++) {
			sum=firstNum+secondNum;
			//System.out.println(i+" "+sum+" "+firstNum+" "+secondNum);
			firstNum=secondNum;
			secondNum=sum;
			System.out.println(sum);
			//System.out.println(i+" "+sum+" "+firstNum+" "+secondNum);
		}
		


	}
}

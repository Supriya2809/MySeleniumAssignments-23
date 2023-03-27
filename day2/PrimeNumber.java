package week1.day2;


public class PrimeNumber {
	 /* Goal: To find whether a number is a Prime number or not
	 * 
	 * input: 13
	 * output: 13 is a Prime Number
	 * 
	 * Shortcuts:
	 * 1) Print : type: syso, followed by: ctrl + space + enter
	 * 2) To create a 'for' loop: type 'for', followed by ctrl + space + down arrow + enter
	 * 3) To create an 'if' condition: type 'if', followed by ctrl + space +down arrow + enter
	 *   
	 * What are my learnings from this code?
	 * 1)Any number divisible by 2 is not prime so once reminder is 0, we can confirm the number is not prime and we can break out of loop
	 * 2)for loop can start on any integer value
	 * 3)if i have a reminder, then it is a prime number
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=450,rem;
		boolean flag=false;
		for (int i=2;i<=num/2;i++) {
			rem=num%i;
			//System.out.println(rem+" "+i+" "+num);
			if(rem==0) {
				flag=true;
				break;
			}
			
			
		}
		//System.out.println(flag);
		if(flag==true) {
			System.out.println("The number "+num+" is not a prime number");
		}
		else {
			System.out.println("The number "+num+" is a prime number");
		}

	}

}

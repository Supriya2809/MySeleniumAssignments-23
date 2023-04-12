package JavaChallenge;

public class SquarerootChallenge2 {


		
		public static double square(int number){
			double t;
			double squareroot = number / 2;
			do 
			{
			t = squareroot;
			squareroot = (t + (number / t)) / 2;
			}
			 while ((t - squareroot) != 0);
			return squareroot;
			}
			public static void main(String[] args)
			{
			int number = 127;
			int root;
			root = (int)(square(number));
			System.out.println("Number : "+number);
			System.out.println("Square Root : "+root);
		
			
	}

}

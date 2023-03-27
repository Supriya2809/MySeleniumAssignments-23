package week1.day2;

public class NegnumToPosnum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NegnumToPosnum objNegnum=new NegnumToPosnum();
		objNegnum.method1();
		objNegnum.method2();


	}
	public void method1() {
		int a=-10,b;
		b=Math.abs(a);
		System.out.println("The number "+a+" is converted to "+b);
	}
	public void method2() {
		int a=-10,b;
		b=a*-1;
		System.out.println("The number "+a+" is converted to "+b);
	}

}

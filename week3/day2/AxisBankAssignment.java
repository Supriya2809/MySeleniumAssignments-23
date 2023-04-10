package week3.day2;

public class AxisBankAssignment extends BankInfoAssignment{

//	Methods :deposit()
	
	public void deposit() {
		System.out.println("This is the deposit for child class");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		AxisBankAssignment childobj=new AxisBankAssignment();
		childobj.deposit();
		childobj.saving();
		childobj.fixed();
	}

}

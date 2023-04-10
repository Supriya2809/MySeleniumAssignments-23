package week3.day2;

public class StudentAssignment {

	public static void main(String[] args) {
		int id=500045;
		String name="Sarah";
		String email=new String("Sarah@mail.com");
		long phoneno=9234618335L;
		StudentAssignment objectstudent=new StudentAssignment();
		objectstudent.getStudentInfo(id);
		objectstudent.getStudentInfo(id, name);
		objectstudent.getStudentInfo(email, phoneno);

	}

	public void getStudentInfo(int id) {
		System.out.println("Single arg method.Id: "+id);
	}
	public void getStudentInfo(int id,String name) {
		System.out.println("TWo arg method .\nId: "+id+"\nname: "+name);
	}
	public void getStudentInfo(String email,long phoneno) {
		System.out.println("Two arg method.\nEmail: "+email+"\nPhone NO.:"+phoneno);
	}
}

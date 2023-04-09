package org.system;

public class Automation extends MultipleLanguage implements Language, TestTool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Automation objautomation=new Automation();
		objautomation.python();
		objautomation.ruby();
		objautomation.Java();
		objautomation.Selenium();
		
		
	}

	@Override
	public void ruby() {
		System.out.println("Ruby is used for automation testing");
		
	}

	public void Java() {
		// TODO Auto-generated method stub
		System.out.println("Java is used for automation testing");
	}

	public void Selenium() {
		// TODO Auto-generated method stub
		System.out.println("This is testing tool");
		
	}

}

package org.system;

public class Desktop extends Computer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Desktop objparent=new Desktop();
		objparent.desktopSize();
		objparent.computerModel();
	}
	public void desktopSize() {
		System.out.println("The desktop screen resolution size is 1920×1080");
	}

}

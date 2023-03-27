package week1.day2;

public class Tab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tab objTab=new Tab();
		System.out.println(objTab.tabBrand(null));
		System.out.println(objTab.tabPrice(0));
		

	}
	public int tabPrice(int tabPrice) {
		tabPrice=5000;
		return tabPrice;
				
	}
	public String tabBrand(String tabBrand) {
		tabBrand="Samsumg";
		return tabBrand;
	}
	
	}

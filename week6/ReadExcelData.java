package week6;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {


	public static void main(String[] args) throws IOException {
	
		//Step:1 Identify the workbook/excel book -->set the path for the workbook
		//Create a folder under project  -->rightclick -->new-->folder-->data-->paste the excelfile under the folder
		XSSFWorkbook book=new XSSFWorkbook("./data/CreateLeadTestdata.xlsx");
		
		//step:2 Identify the sheet in the book 
		XSSFSheet sheet = book.getSheetAt(0); //index starts with zero --.represent Sheet1
		//book.getSheet("CL");//sheet name
		
		//step:3 Get into the Row of the particular sheet
		XSSFRow row = sheet.getRow(1);//index with zero-->row 1 in Excel sheet
		//Step:4 Get into Cell/column
		//from the first row-->all columns -->1,2,3,...
		XSSFCell cell = row.getCell(3); //index zero -->represent the column
		
		//Step:5 To read the value from cell
		//book-->sheet-->row-->column-->value		
		String valueFromCell = cell.getStringCellValue();		
		System.out.println(valueFromCell);
		
		
	//To get the rowSize--> number of rows in the excel sheet
		
		int rowCount= sheet.getLastRowNum();	//it ignores first row of the excel sheet and by default it is taken as header
		System.out.println(rowCount);
				
	//To get the ColumnSize-->number of columns in the excelSheet
		int columCount = row.getLastCellNum();
		
		//it includes the header of the excel sheet and give the available rows in the sheet
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		System.out.println(physicalNumberOfRows);
		
		System.out.println(columCount);
		//Read all the datas from the sheet
		//nested loop
		
		  for(int i=0;i<=rowCount;i++) {//row 3,4 
			  for(int j=0;j<=columCount;j++) {//column ->0123
		  //book-->sheet-->row-->column-->value
			  String stringCellValue = sheet.getRow(i).getCell(j).getStringCellValue();
		  System.out.println(stringCellValue);
		  }
		  }		 
		
		//mantadory step close the workbook
		book.close();

		
	}

}

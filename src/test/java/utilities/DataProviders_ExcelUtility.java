package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders_ExcelUtility {
	
	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException {
		
		String path=".\\testData\\DDTLogin.xlsx"; // taking xlsx from testData
		
		ExcelUtility excel= new ExcelUtility(path); //creating object of class
		
		int totalrows=excel.getRowCount("loginDDT");
		int totalcols=excel.getCellCount("loginDDT", 1);
		
		String logindata[][]=new String[totalrows][totalcols];//creating two dimension array to stor row and col
		
		for(int i=1;i<=totalrows;i++) { //0   i is rows j is col
			
			for(int j=0;j<totalcols;j++) {
				
				logindata[i-1][j]=excel.getCellData("loginDDT", i, j); //1,0
			}
		}
				
		return logindata; //returning two dimensionalarray
		
	}
	
	//Another DataProvider method can be store here if needed
	
	//DataProvider 2

}

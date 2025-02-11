package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

public class ExcelProvider {
	
	
	@DataProvider(name="TestLogin")
	public String[][]getData(Method m) throws EncryptedDocumentException, IOException{
		
		String excelSheetName=m.getName();
		File f=new File(".\\testData\\DDT.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet(excelSheetName);
		
		int totalRows = sheetName.getLastRowNum();
		Row rowCells=sheetName.getRow(0);
		int totalCols=rowCells.getLastCellNum();
		
		DataFormatter format = new DataFormatter();
		
		String data[][]=new String[totalRows][totalCols];
		for(int i=1; i<totalRows; i++) {
			for(int j=0; j<totalCols; j++) {
				data[i-1][j]=format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(data[i-1][j]);
				
				
			}
		}
		return data;
	
}
	
	
	
	
	
	/*@DataProvider(name="TestLogin")
	public static Object dataDrivenTesting() throws IOException {
	//public String [][] getData(Method m) throws IOException {
	
        FileInputStream file = new FileInputStream(".\\textData\\DDT.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		XSSFSheet sheet=workbook.getSheet("Sheet1");         //XSSFSheet sheet=workbook.getSheetAt(0);
		
		int totalRows=sheet.getLastRowNum();
		
		int totalCells=sheet.getRow(1).getLastCellNum();
		
		System.out.println("number of rows: "+totalRows); 
		System.out.println("number of cells: "+totalCells);
		
		for(int r=0; r<=totalRows; r++) {
			
			XSSFRow currentRow=sheet.getRow(r);
			
			for(int c=0;c<totalCells; c++){
				
				XSSFCell cell=currentRow.getCell(c);
				System.out.print(cell.toString()+  "\t");  // read any type of format into string format and add decimal to the number
				
			}
			
			System.out.println();
		}
		workbook.close();
		file.close();
		return null;

	
	

	
	}*/

}

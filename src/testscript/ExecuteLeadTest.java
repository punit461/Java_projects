package testscript;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class ExecuteLeadTest {

	public static void main(String[] args) throws Exception{
		Keywords key = new Keywords();
		ArrayList<Comparable> a = new ArrayList();
		FileInputStream file = new FileInputStream("E:\\Project_Zoho\\LeadSuite.xlsx");
		XSSFWorkbook wbks = new XSSFWorkbook(file);
		Sheet s = (Sheet) wbks.getSheet("TestSteps");
		
		Iterator<Row> itr= s.iterator();
		while(itr.hasNext()) {
			Row rowitr = (Row) itr.next();
			Iterator<Cell> cellitr = rowitr.cellIterator();
			while(cellitr.hasNext()) {
				Cell cell = (Cell) cellitr.next();
		
				switch (cell.getCellType()) {
				case STRING:
					a.add(cell.getStringCellValue());
					break;
				case NUMERIC:
					a.add(cell.getNumericCellValue());
					break;
				case BOOLEAN:
					a.add(cell.getBooleanCellValue());
					break;

				}	
			}	
			
			
		}
			
		for (int i = 0; i < a.size(); i++) {
			if(a.get(i).equals("openbrowser")){
				String keyword = (String) a.get(i);
				String data = (String) a.get(i+1);
				String objectName = (String) a.get(i+2);
				String runmode = (String) a.get(i+3);
				System.out.println(keyword);
				System.out.println(data);
				System.out.println(objectName);
				System.out.println(runmode);
				
				if(runmode.equals("yes")) {
					key.openbrowser();
				}
			}
			
			if(a.get(i).equals("navigate")){
				String keyword = (String) a.get(i);
				String data = (String) a.get(i+1);
				String objectName = (String) a.get(i+2);
				String runmode = (String) a.get(i+3);
				System.out.println(keyword);
				System.out.println(data);
				System.out.println(objectName);
				System.out.println(runmode);
				
				if(runmode.equals("yes")) {
					key.navigate(data);
				}
			}
			
			if(a.get(i).equals("input")){
				String keyword = (String) a.get(i);
				String data = (String) a.get(i+1);
				String objectName = (String) a.get(i+2);
				String runmode = (String) a.get(i+3);
				System.out.println(keyword);
				System.out.println(data);
				System.out.println(objectName);
				System.out.println(runmode);
				
				if(runmode.equals("yes")) {
					key.input(data, objectName);
				}
			}
			
		
		
		
		
		
		
		
		
		
		}
		
		
		
	}
	
	
}

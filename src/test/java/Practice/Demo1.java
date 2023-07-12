package Practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Demo1 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		Workbook wb = WorkbookFactory.create(new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\SDET49_SupplyChainManagement_SeleniumHybrid\\TestData\\input.xlsx"));	
		String xyz = wb.getSheet("Sheet1").getRow(0).getCell(0).toString();
		System.out.println(xyz);
		
	}

}

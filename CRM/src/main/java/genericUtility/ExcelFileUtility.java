package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	//Read data from excel
		public String toReadDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
			FileInputStream fis= new FileInputStream("./configAppData/TestScriptData.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
			wb.close();
			return data;
		}
}

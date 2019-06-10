package hrm.keyworddriven;

import java.io.File;
import java.io.FileInputStream;

import jxl.Sheet;
import jxl.Workbook;

public class ExcelReader {
	Workbook book;
	Sheet sh;

	public static String getFilePath(String folderName, String fileName) {
		return System.getProperty("user.dir") + File.separator + folderName + File.separator + fileName;
	}

//	set excel file to read the data
	public ExcelReader(String folderName, String fileName, String sheetName) {
		try {
			FileInputStream fis = new FileInputStream(getFilePath(folderName, fileName));
			book = Workbook.getWorkbook(fis);
			sh = book.getSheet(sheetName);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
//	get the no of rows
	public int rowCount() {
		return sh.getRows();
	}
	
//	get the no of columns
	public int columnCount() {
		return sh.getColumns();
	}
	
//	read the data
	public String readData(int rnum, int cnum) {
		return sh.getCell(cnum, rnum).getContents();
	}

}

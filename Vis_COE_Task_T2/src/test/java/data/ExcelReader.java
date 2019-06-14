package data;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;

	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class ExcelReader {

		static FileInputStream fis = null;

		public static FileInputStream getFileInputStream() {
			String FilePath = System.getProperty("user.dir") + "/src/test/java/data/TestData.xlsx";
			File SrcFile = new File(FilePath);
			try {
				fis = new FileInputStream(SrcFile);
			} catch (FileNotFoundException e) {
				System.out.println("Test Data File not found" + e.getMessage());
				System.exit(0);
			}

			return fis;
		}

		public Object[][] getExcelData() throws IOException {
			fis = getFileInputStream();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(0);
			int totalRows = sheet.getLastRowNum();
			int totalCols =1;

			String[][] arrayExcelData = new String[totalRows][totalCols];
			for (int i = 0; i < totalRows; i++) {

				for (int j = 0; j < totalCols; j++) {
					XSSFRow row = sheet.getRow(i);
					arrayExcelData[i][j] = row.getCell(j).toString();
				}
			}

wb.close();
		return arrayExcelData;
	}
	}



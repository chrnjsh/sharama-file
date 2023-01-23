package generic_Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData {

		/**
		 * this method is used to read the data from the property file
		 * @param key    you have to pass key data to read the value
		 * @return it will return the value based on the key passed.
		 */
		public static String fromProperty(String key) {
			FileInputStream fis=null;
			Properties properties=new Properties();;
			try {
				fis=new FileInputStream(new File("./src/test/resources/testData/configuration.properties"));
				properties.load(fis);
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			catch(EncryptedDocumentException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			return properties.getProperty(key).toString();
		}
		
		/**
		 * This method is used to read the string data from excel file of both xlx and xlsx format.
		 * @param sheet you have to pass the sheet name 
		 * @param rowNo you have to pass the rowno and the index is starts from 0.
		 * @param cellNo you have to column number in the integer format and the index is starts from 0.
		 * @return it will return the string data.
		 */
		public static String fromExcel(String sheet,int rowNo,int cellNo) {
			FileInputStream fis=null;
			Workbook workbook=null;
			try {
				fis=new FileInputStream(new File("./src/test/resources/testData/testData.xlsx"));
				 workbook=WorkbookFactory.create(fis);
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			catch(EncryptedDocumentException e) {
				e.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			return workbook.getSheet(sheet).getRow(rowNo).getCell(cellNo).getStringCellValue();
		}
		
		/**
		 * This method is used to read the number data from excel file of both xlx and xlsx format.
		* @param path you have to pass the location or path of the file location.
		 * @param sheet you have to pass the sheet name 
		 * @param rowNo you have to pass the rowno and the index is starts from 0.
		 * @param cellNo you have to column number in the integer format and the index is starts from 0.
		 * @return it will return the integer type of data.
		 */
		public static int fromExcelNumber(String sheet,int rowNo,int cellNo) {
			FileInputStream fis=null;
			Workbook workbook=null;
			try {
				fis=new FileInputStream(new File("./src/test/resources/testData/testData.xlsx"));
				 workbook=WorkbookFactory.create(fis);
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			catch(EncryptedDocumentException e) {
				e.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			return (int) workbook.getSheet(sheet).getRow(rowNo).getCell(cellNo).getNumericCellValue();
		}
		
		/**
		 * this method is used to read the date in the excel file of both xls and xlsx
		 * @param sheet you have to pass the sheet name 
		 * @param rowNo you have to pass the rowno and the index is starts from 0.
		 * @param cellNo you have to column number in the integer format and the index is starts from 0.
		 * @return it will return the date
		 */
		
		public static LocalDateTime fromExcelDate(String sheet,int rowNo,int cellNo) {
			FileInputStream fis=null;
			Workbook workbook=null;
			try {
				fis=new FileInputStream(new File("./testData/testData.xlsx"));
				 workbook=WorkbookFactory.create(fis);
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			catch(EncryptedDocumentException e) {
				e.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			return  workbook.getSheet(sheet).getRow(rowNo).getCell(cellNo).getLocalDateTimeCellValue();
		}
		
		/**
		 * This method is used to receive the data which is present in excel.
		 * @param sheetName enter the sheetname of excel
		 * @return it will return the data which is present in the excel
		 * @throws Exception
		 */
		public String[][] readDataExcel(String sheetName) throws Exception {
			FileInputStream fis=new FileInputStream(new File("./testData/testData.xlsx"));
			Workbook data = WorkbookFactory.create(fis);
			Sheet sheetInfo = data.getSheet(sheetName);
			int colCount=sheetInfo.getRow(0).getPhysicalNumberOfCells();
			int rowCount=sheetInfo.getPhysicalNumberOfRows()-1;
			String[][] info=new String[rowCount][colCount];

			for(int i=0;i<info.length;i++) {
				for(int j=0;j<info[i].length;j++) {
					info[i][j]=sheetInfo.getRow(i+1).getCell(j).toString();
				}
			}
			return info;
		}
		/**
		 * This method is used to fetch the data from excel and it will only fetch the data based on the rowno
		 * @param sheetName enter the sheet name of the page
		 * @param rowNo enter the rowno in which row the required data is present.
		 * @return it will return the all the data in the form of string array.
		 */
		public static String[][] readDataExcel(String sheetName,int rowNo) {
			FileInputStream fis=null;
			Workbook workbook=null;
			try {
				fis=new FileInputStream(new File("./src/test/resources/testData/testData.xlsx"));
				 workbook=WorkbookFactory.create(fis);
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			catch(EncryptedDocumentException e) {
				e.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			Sheet sheet = workbook.getSheet(sheetName);
			int colCount=sheet.getRow(rowNo).getPhysicalNumberOfCells()-1;
			String info[][]=new String[1][colCount];
			
				for(int j=0;j<colCount;j++) {
					info[0][j]=sheet.getRow(rowNo).getCell(j+1).getStringCellValue();
				}
			return info;
			}
			
		}
		



			
			
		
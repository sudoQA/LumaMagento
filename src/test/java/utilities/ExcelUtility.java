package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public FileInputStream fis;
	public FileOutputStream fos;
	public XSSFWorkbook workBook;
	public XSSFSheet sheet;
	public XSSFCell cell;
	public XSSFRow row;
	public CellStyle style;
	public String path;
	public String sheetName;
	public int rowCount;
	public int cellCount;
	private String data;
	
	public ExcelUtility(String path) {
		this.path = path;
	}

	public int getRowCount(String sheetName) {
		try {

			fis = new FileInputStream(path);
			workBook = new XSSFWorkbook(fis);
			sheet = workBook.getSheet(sheetName);
			rowCount = sheet.getLastRowNum();
			workBook.close();
			fis.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowCount;

	}

	public int getCellCount(String sheetName, int rownum) {
		try {
			fis = new FileInputStream(path);
			workBook = new XSSFWorkbook(fis);
			sheet = workBook.getSheet(sheetName);
			row = sheet.getRow(rownum);
			cellCount = row.getLastCellNum();
		} catch (Exception e) {
			e.getMessage();
		}

		return cellCount;
	}

	public String getCellData(String sheetName, int rownum, int colnum) {
		try {
			fis = new FileInputStream(path);
			workBook = new XSSFWorkbook(fis);
			sheet = workBook.getSheet(sheetName);
			row = sheet.getRow(rownum);
			cell = row.getCell(colnum);

			DataFormatter formatter = new DataFormatter();
			try {
				data = formatter.formatCellValue(cell); // return the cell's value in a string format
			} catch (Exception e) {
				data = "";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;

	}
	
	public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException
	{
		File xlFile = new File(path);
		if(!xlFile.exists())
		{
			workBook = new XSSFWorkbook();
			fos = new FileOutputStream(path);
			workBook.write(fos);	
		}
		
		fis = new FileInputStream(path);
		workBook = new XSSFWorkbook(fis);
		
		if(!(workBook.getSheetIndex(sheetName)==-1))     //if sheet does not exist
		{
			workBook.createSheet(sheetName);
		}
		sheet = workBook.getSheet(sheetName);
		
		
		if(sheet.getRow(rownum)==null)
		{
			sheet.createRow(rownum);
		}
		row=sheet.getRow(rownum);
		
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fos = new FileOutputStream(path);
		workBook.write(fos);
		workBook.close();
		fos.close();
	}
	
	public void fillGreenColor(String sheetName, int rownum, int colnum) throws IOException
	{
		fis = new FileInputStream(path);
		workBook = new XSSFWorkbook(fis);
		
		sheet = workBook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		style = workBook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		
		cell.setCellStyle(style);
		fos = new FileOutputStream(path);
		workBook.write(fos);
		workBook.close();
		fis.close();
		fos.close();
	}
	
	public void fillRedColor(String sheetName, int rownum, int colnum) throws IOException
	{
		fis = new FileInputStream(path);
		workBook = new XSSFWorkbook(fis);
		
		sheet = workBook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		style = workBook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		
		cell.setCellStyle(style);
		fos = new FileOutputStream(path);
		workBook.write(fos);
		workBook.close();
		fis.close();
		fos.close();
	}

}
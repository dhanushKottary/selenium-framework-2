package com.banking.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlfile, String xlsheet) {
		
		int rowCount = -1;
		try {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		rowCount = ws.getLastRowNum();
		wb.close();
		fi.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
	
	public static int getCellCount(String xlfile, String xlsheet, int rownum) {
		int cellCount = -1;
		try {
			
			fi = new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(xlsheet);
			row = ws.getRow(rownum);
			cellCount = row.getLastCellNum();
			wb.close();
			fi.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cellCount;
	}
	
	public static String getCellData(String xlfile, String xlsheet, int rownum, int colnum) {
		String cellData = null;
		try {
			
			fi = new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(xlsheet);
			row = ws.getRow(rownum);
			cell = row.getCell(colnum);
			//cellData = cell.getStringCellValue();
			DataFormatter dataformatter = new DataFormatter();
			cellData = dataformatter.formatCellValue(cell);
			wb.close();
			fi.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cellData;
	}
	
	public static void setCellData(String xlfile, String xlsheet, int rownum, int colnum, String data) {
		try {
			
			fi = new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(xlsheet);
			row = ws.getRow(rownum);
			cell = row.getCell(colnum);
			cell.setCellValue(data);
			fo = new FileOutputStream(xlfile);
			wb.write(fo);
			wb.close();
			fi.close();
			fo.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	

}

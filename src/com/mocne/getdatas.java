package com.mocne;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.IOException;  
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.DateUtil;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.ss.usermodel.Sheet;  
import org.apache.poi.ss.usermodel.Workbook;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class getdatas {
    private static final String EXCEL_XLS = "xls";  
    private static final String EXCEL_XLSX = "xlsx";  
    
    
    public static void main(String[] args) throws IOException {
    	exportDataFromExcel();
    }
    
    public static Workbook getWorkbok(InputStream in,File file) throws IOException{   
        Workbook wb = null;  
        if(file.getName().endsWith(EXCEL_XLS)){  //Excel 2003  
        wb = new HSSFWorkbook(in);  
        }else if(file.getName().endsWith(EXCEL_XLSX)){  // Excel 2007/2010  
            wb = new XSSFWorkbook(in);  
        }  
        return wb;
    }  

    public static void checkExcelVaild(File file) throws Exception{  
        if(!file.exists()){  
            throw new Exception("can not open it");
        }  
        if(!(file.isFile() && (file.getName().endsWith(EXCEL_XLS) || file.getName().endsWith(EXCEL_XLSX)))){  
            throw new Exception("file is not Excel");
        }
    }

    @SuppressWarnings({ "unused", "deprecation" })
	public static Map<String, Object> exportDataFromExcel() throws IOException {  

    	LinkedList<String> titles = new LinkedList<String>();
		Map<String , Object> rowData = new HashMap<String, Object>(); 
		Map<String , Object> sheetData = new HashMap<String, Object>();
		Map<String , Object> workbookData = new HashMap<String, Object>();
		
    	SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");  
		try {  
			File excelFile = new File("E:/test.xlsx"); 
			FileInputStream is = new FileInputStream(excelFile); 
			checkExcelVaild(excelFile);  
			Workbook workbook = getWorkbok(is,excelFile);  
			//Workbook workbook = WorkbookFactory.create(is); 
			
			int sheetCount = workbook.getNumberOfSheets();  

			for (Sheet sheet : workbook) {
				String sheetName = sheet.getSheetName();
				int count = 0;  
		        for (Row row : sheet) {  
		            if(count == 0){ 
		            	for (Cell cell : row) {
		            		titles.add(cell.getRichStringCellValue().getString());
						}
		            	Iterator<String> it = titles.iterator();
	//	            	while (it.hasNext()) {
	//	            		System.out.println(it.next());
	//	            	}
		                count++;  
		                continue;  
		            }  

		            if(row.getCell(0).toString().equals("")){  
		                return null ;  
		            }  
		            String rowValue = "";  
		            for (Cell cell : row) {  
		                if(cell.toString() == null){  
		                    continue;  
		                }  
		                int cellType = cell.getCellType();  
		                String cellValue = "";  
		                switch (cellType) {  
		                    case Cell.CELL_TYPE_STRING:     
		                        cellValue = cell.getRichStringCellValue().getString();  
		                        break;  
		                    case Cell.CELL_TYPE_NUMERIC:    
		                        if (DateUtil.isCellDateFormatted(cell)) {  
		                            cellValue = fmt.format(cell.getDateCellValue());  
		                        } else {  
		                            cell.setCellType(Cell.CELL_TYPE_STRING);  
		                            cellValue = String.valueOf(cell.getRichStringCellValue().getString());  
		                        }  
		                        break;  
		                    case Cell.CELL_TYPE_BOOLEAN:    
		                        cellValue = String.valueOf(cell.getBooleanCellValue());  
		                        break;  
		                    case Cell.CELL_TYPE_BLANK: 
		                        cellValue = cell.getStringCellValue();  
		                        break;  
		                    case Cell.CELL_TYPE_ERROR:   
		                        cellValue = "#ERROR#";  
		                        break;  
		                    case Cell.CELL_TYPE_FORMULA:      
		                        cell.setCellType(Cell.CELL_TYPE_STRING);  
		                        cellValue = String.valueOf(cell.getRichStringCellValue().getString());  
		                        break;  
		                    default:  
		                        cellValue = "";
		                }
		                rowData.put(titles.get(cell.getColumnIndex()), String.valueOf(cellValue));   
		            }       
		            sheetData.put(String.valueOf(row.getRowNum()), rowData);
		            rowData.clear();
		        }
	        workbookData.put(sheetName, sheetData);
			}
	    } catch (Exception e) {
	        e.printStackTrace();  
	    } finally{   
	    } 
		System.out.println(workbookData);
		return workbookData;
    } 
}
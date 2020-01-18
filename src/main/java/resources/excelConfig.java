package resources;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class excelConfig {
    XSSFWorkbook wb;
    XSSFSheet sh;

    public excelConfig(String path) throws IOException {
        File src = new File(path);
        FileInputStream fis = new FileInputStream(src);
        wb = new XSSFWorkbook(fis);

    }

    public String getdata(int Sheetnumber, int row, int column) {
       sh =wb.getSheetAt(Sheetnumber);
       String data= sh.getRow(row).getCell(column).getStringCellValue();
       return data;
    }
}


package data;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader2 {

    static FileInputStream fileInputStream = null;

    public FileInputStream getFileInputStream(){

        String srcFilePath = System.getProperty("user.dir")+"src/test/java/data/ExcelReader2.java";
        File file = new File(srcFilePath);

        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
           System.out.println("there is no such data here , Error was found.");
        }
        return fileInputStream;
    }


    public Object[][] getExcelData() throws IOException {
        fileInputStream = getFileInputStream();

        XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = wb.getSheetAt(0);

        int TotalNumberOfRows = (sheet.getLastRowNum() + 1);
        int TotalNumbersOfColumns = 4;


        String [][] ColumnsAndRowsData = new String[TotalNumberOfRows][TotalNumbersOfColumns];

        for (int i = 0; i <TotalNumberOfRows ; i++) {

            for (int j = 0; j <TotalNumbersOfColumns ; j++) {

                XSSFRow row = sheet.getRow(i);
                ColumnsAndRowsData[i][j] = row.getCell(j).toString();
            }
        }
        wb.close();
        return ColumnsAndRowsData;
    }

}

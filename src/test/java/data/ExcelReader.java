package data;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    static FileInputStream  fileInputStream = null;

    public FileInputStream getFileInputStream(){

        String srcPath = System.getProperty("user.dir")+"src/test/java/data/Userdata.xlsx";
        File file = new File(srcPath);

        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("There is an error please check your data , or pleas check yor Excel file");
        }

        return fileInputStream;
    }

    // we make two Object
    public Object[][] getExcelData() throws IOException {
        fileInputStream = getFileInputStream();

        // then we will get file workbook and file work sheet

        XSSFWorkbook wb = new XSSFWorkbook(fileInputStream);
        XSSFSheet sheet = wb.getSheetAt(0);

        // get the numbers of columns and numbers of rows

        int TotalNumberOFRows = (sheet.getLastRowNum() + 1);
        int TotalNumberOfColumns = 4;

        //Then we make two arrays

        String [][] ColumnsAndRowsData = new String[TotalNumberOFRows][TotalNumberOfColumns];

        for (int i = 0; i < TotalNumberOFRows; i++) {
            for (int j = 0; j < TotalNumberOfColumns; j++) {
                XSSFRow row = sheet.getRow(i);
                ColumnsAndRowsData[i][j] = row.getCell(j).toString();
            }
        }
        wb.close();
        return ColumnsAndRowsData;




    }
}

package utilities;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//  este HSS sau XSS in functie de cum este xlsx sau xls

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataReader {

    public static HashMap<String, String> storeValues = new HashMap();

    public static List<HashMap<String, String>> data(String filepath, String sheetName) throws IOException
    {

        List<HashMap<String, String>> mydata = new ArrayList<>();

        FileInputStream file = new FileInputStream(filepath);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        int totalRows=sheet.getLastRowNum();

        XSSFRow headerRow=sheet.getRow(0);


        for (int i = 1; i <= totalRows; i++)
        {
            XSSFRow currentRow = sheet.getRow(i);

            HashMap<String, String> currentHash = new HashMap<String, String>();

            for (int j = 0; j < currentRow.getLastCellNum(); j++)
            {
                XSSFCell currentCell = currentRow.getCell(j);
                currentHash.put(headerRow.getCell(j).toString(), currentCell.toString());
            }
            mydata.add(currentHash);
        }
        file.close();

        return mydata;
    }

}

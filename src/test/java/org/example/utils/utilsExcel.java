package org.example.utils;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//open that fileInputStream
//understand the workbook
//Sheet
//Row
//column
//cell
// close the stream
public class utilsExcel {

    //It will be used by Dataprovider of TestNG
    //Object[][]
  public static String FILE_NAME ="PATHOFFILE";
  static Workbook book;
  static Sheet sheet;
    public static Object[][] getTestData(String sheetName){

        FileInputStream file = null;
        try{
            file = new FileInputStream(FILE_NAME);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        try {
            book = WorkbookFactory.create(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sheet = (Sheet) book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        for(int i=0;i<sheet.getLastRowNum();i++){
                for(int j=0; j<sheet.getRow(0).getLastCellNum();j++){
                           data[i][j]= sheet.getRow(i+1).getCell(j).toString();
                }
        }
          return data;
    }

@DataProvider
    public Object[][] getData(){
        //In future i can write a logic which sheet i want to open
    // Ask user which sheet they want to open
    //Data.properties --> Sheet 1 or Sheet 2
    //sheet 1--> user/password - QA Env.
    //sheet 2 --> user/password - prd Env.
        return getTestData("Sheet1");
    }

}

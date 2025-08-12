package org.example.tests.extendDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
public class TestNGListener {

    private static ExtentReports extent;
   // private static ExtentHtmlReported htmlReporter;
    private static ExtentTest test;

    public static ExtentReports getInstance(){
             if(extent == null){
                 //htmlReporter = new ExtentHtmlReported(path = "extentReport.html")
                 //htmlReporter.config().setTheme()
                 //htmlReporter.config().setDocumemtTitle


                 extent = new ExtentReports();
                // extent.attachReporter(htmlReporter);
                 extent.setSystemInfo("OS","Mac");
                 extent.setSystemInfo("Tester","Pramode");
             }
             return  extent;
    }
              public static ExtentTest createTest (String testName, String description){
                  test = extent.createTest(testName,description);
                  return test;
              }
}

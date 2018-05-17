package com.DataDrivenPark;

import ExcelDataLibrary.Xls_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Execute_DataParamTest {

@Test
    public void Execute_DataParamTest(){

        WebDriver driver;

        //OpenBrowser
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium_Jars_Extensions\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://executeautomation.com/demosite/Login.html");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


        Xls_Reader reader = new Xls_Reader("C:\\Users\\olatu\\IdeaProjects\\DataDrivenProject2\\src\\test\\java\\com\\TestData\\SpecData.xlsx");
        int rowCount = reader.getRowCount("Executive");

        for (int rowNum = 2; rowNum <= rowCount; rowNum++) {


            //Login Parameterization
                //creating String param for login page
            String UserName = reader.getCellData("Executive", "UserName", rowNum);
            String Password = reader.getCellData("Executive", "Password", rowNum);

            //Login  page
               //creating findElement for login page

            driver.findElement  (By.name("UserName")).sendKeys(UserName);
            driver.findElement(By.name("Password")).clear();
            driver.findElement(By.name("Password")).sendKeys(Password);
            driver.findElement(By.xpath("//*[@id='userName']/p[3]/input")).click();
            driver.findElement(By.xpath("//*[@id='cssmenu']/ul/li[1]/a/span")).click();

            //UserForm Parameterization
               //creating String param for user form


            //UserForm Page
                //creating findElement for user form
        }

            //TearDown
             driver.close();

    }

    }



package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    Utils readFile = new Utils();
    public String baseUrl ="";
    //	String driverPath = "\\Users\\veronicagonsalves\\downloads\\chromedriver.exe";
    public WebDriver driver;

    @Test(priority = 1)
    public void test() throws IOException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        String baseUrl=readFile.reader("baseUrl");
        System.out.print(baseUrl);
        driver.get(baseUrl);
        // get the current URL of the page
        String URL = driver.getCurrentUrl();
        System.out.print(URL);
        //get the title of the page
        String title = driver.getTitle();
        System.out.println(title);
    }
}
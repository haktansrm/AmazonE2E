package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.TestInstance;

public class BaseTest {
    WebDriver driver;
    @BeforeMethod
    public  void waitUp() throws InterruptedException {
        Thread.sleep(2000);

    }

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com.tr/");
        driver.manage().window().maximize();

    }

   /* @AfterTest
    public void tearDown(){
        driver.quit();
    }*/
}

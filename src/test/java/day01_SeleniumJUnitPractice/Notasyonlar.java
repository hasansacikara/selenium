package day01_SeleniumJUnitPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class Notasyonlar {
    WebDriver driver;
    String https="https://www";
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void teardown(){

        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://amazon.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.navigate().to("https://www.N11.com");
        driver.navigate().back();
        System.out.println(driver.getWindowHandle());
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();



    }

    @Test
    public void test02() throws InterruptedException {

        driver.get("https://www.google.com");
        String ilkSayfaHandleDegeri= driver.getWindowHandle();
        System.out.println(driver.getWindowHandle());
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(3000);
        driver.navigate().to("https://www.amazon.com");
        Thread.sleep(3000);
        System.out.println(driver.getWindowHandles());
        driver.switchTo().window(ilkSayfaHandleDegeri);
        Thread.sleep(3000);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.wisequarter.com");


    }


}
package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q02 {

    WebDriver driver;
    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @After
    public void teardown(){

        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.trendyol.com/");
        driver.findElement(By.xpath("//a[@class=\"category-header\"]"));
        driver.findElement(By.name("//input[@class=\"vQI670rJ\"]")).click();
        driver.findElement(By.linkText("//a[@class=\"sub-category-header\"]"));
        driver.findElement(By.name("Elbise")).click();
        driver.findElement(By.xpath("image-overlay-body")).click();
        driver.findElement(By.id("id=\"container\"")).click();
        driver.findElement(By.xpath("prc-dsc"));
        driver.findElement(By.linkText("//[@class=\"gender-popup-lock\"]"));

        Thread.sleep(5,00000);


        String expectedKelime= "trendYol";
        String actualUrl= driver.getCurrentUrl();

          Assert.assertEquals(expectedKelime,actualUrl);

          Thread.sleep(10000000);







    }
}

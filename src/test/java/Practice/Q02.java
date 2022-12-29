package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
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

    public void test01(){
        driver.get("https://www.trendyol.com/");
        driver.findElement(By.xpath("//idata-testid=\"search-icon\"")).click();
        driver.findElement(By.linkText("//a[@class=\"item\"]")).getText();
        driver.findElement(By.linkText("//[@class=\"category-header\"]")).click();

        String expectedKelime= "amazon";
        String actualUrl= driver.getCurrentUrl();

        // Assert.assertTrue(actualUrl.contains(expectedKelime));







    }
}

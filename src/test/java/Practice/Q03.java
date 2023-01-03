package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q03 {


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

        driver.close();
    }

    @Test
    public void test01(){

        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        //2. “Our Products” butonuna basin
        driver.findElements(By.xpath("//a[@href='products.html']"));




        //3. “Cameras product”i tiklayin
        WebElement cameraButton=driver.findElement(By.id("id=\"camera-img\""));
        cameraButton.click();

        //4. Popup mesajini yazdirin
        System.out.println("Please Note: All orders must be over the value of £50, adding additional coupon codes to the basket are excluded from this offer. To receive 30% off please add the following code to the basket");
        //5. “close” butonuna basin
        WebElement button= driver.findElement(By.className("//button[@class='btn btn-default']"));
        button.click();


        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        WebElement linkClick=driver.findElement(By.linkText("//a[@id='nav-title'][1]"));
        linkClick.click();




        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
















    }
}

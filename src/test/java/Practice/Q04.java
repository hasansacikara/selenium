package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q04 {

    WebDriver driver;
    String https="https://www";
    @Before
    public void setUp(){
        // Gerekli setup islemlerini kuralim
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.automationexercise.com/");
        // signUp linkine tiklayalim
        driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
        String expected="https://www.automationexercise.com/login";
        String actual=driver.getCurrentUrl();
        String nameBox;
        String imailBox;
        Assert.assertEquals(expected,actual);
    }

    @After
    public void teardown(){

        driver.close();
    }

    @Test
    public void test01(){
        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.automationexercise.com/Login");
        // signupa linkine tıklayınız
        driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
        String expected="https://www.automationexercise.com/Login";
        String actual=driver.getCurrentUrl();
        WebElement nameBox= driver.findElement(By.xpath("//input[@name='name']"));
        WebElement imailBox=driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        driver.findElement(By.xpath("//input[@name='name']"));
        driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        nameBox.sendKeys("hasan");
        imailBox.sendKeys("sacikara@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        WebElement title=driver.findElement(By.xpath("//input[@id='id_gender1']"));
        title.click();
        WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
       driver.findElement(By.xpath("123456"));
        WebElement daySelect=driver.findElement(By.xpath("//SELECT[@name='days']"));
        WebElement months=driver.findElement(By.xpath("//select[@name='months']"));
        WebElement years=daySelect.findElement(By.xpath("//select[@name='years']"));
        WebElement checkBox =driver.findElement(By.xpath("//input[@id='newsletter']"));
        checkBox.click();
        WebElement receive=driver.findElement(By.xpath("//input[@name='optin']"));
        receive.click();
        driver.findElement(By.xpath("Address Information")).click();
        Assert.assertEquals(expected,actual);
        WebElement firsName=driver.findElement(By.name("//input[@id='first_name']"));
        firsName.sendKeys();
        WebElement lastName=driver.findElement(By.xpath("//input[@name='last_name']"));
        lastName.sendKeys();
        WebElement company=driver.findElement(By.xpath("//input[@name='company']"));
        company.isDisplayed();
        Assert.assertEquals(expected,actual);

















    }
}

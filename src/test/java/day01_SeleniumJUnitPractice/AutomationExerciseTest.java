package day01_SeleniumJUnitPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ISelect;

import java.time.Duration;

public class AutomationExerciseTest {
    // Gerekli setup islemlerini kuralim
    // https://www.automationexercise.com/ sayfasina gidelim
    // signUp linkine tiklayalim
    // name ve email adress kismina bilgiler gondererek uye olalim
    // uye olundugunu test edelim
    WebDriver driver;


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
        Assert.assertEquals(expected,actual);
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void olumluSeneryo(){

        // name ve email adress kismina bilgiler gondererek uye olalim
        WebElement nameBox= driver.findElement(By.xpath("//input[@type='text']"));
        nameBox.sendKeys("hasan");
        WebElement emailBox=driver.findElement(By.xpath("(//input[@type='email'])[2]"));
        emailBox.sendKeys("hasan@gmail.com");
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        WebElement enterAccountText= driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        Assert.assertTrue(enterAccountText.isDisplayed());
    }

    @Test
    public void olumsuzSeneryo(){
        WebElement nameBox= driver.findElement(By.xpath("//input[@type='text']"));
        nameBox.sendKeys("as");
        WebElement emailBox=driver.findElement(By.xpath("(//input[@type='email'])[2]"));
        emailBox.sendKeys("hasan.gmail.com");
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        WebElement newUserText= driver.findElement(By.xpath("//*[text()='New User Signup!']"));
        Assert.assertTrue(newUserText.isDisplayed());

    }

    @Test
    public void olumsuzSeneryo2(){
        WebElement nameBox= driver.findElement(By.xpath("//input[@type='text']"));
        nameBox.sendKeys("hasan");
        WebElement emailBox=driver.findElement(By.xpath("(//input[@type='email'])[2]"));
        emailBox.sendKeys("hasan@gmailcom");
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        WebElement enterAccountText= driver.findElement(By.xpath("//*[text()='Enter Account Information']"));
        Assert.assertFalse(enterAccountText.isDisplayed());
    }
}

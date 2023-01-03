package day03;

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

public class AutomationExerciseTest {
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
        driver.close();
    }

    @Test
    public void olumlusenaryo(){
           // https://www.automationexercise.com/ sayfasina gidelim
        driver.get("https://www.automationexercise.com/");
         // signUp linkine tiklayalim
        driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
        String expected="https://www.automationexercise.com/Login";
        String actual=driver.getCurrentUrl();
        Assert.assertEquals(expected,actual);
           // name ve email adress kismina bilgiler gondererek uye olalim
        WebElement namebox=driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        namebox.sendKeys("hasan");
       // driver.findElement(By.xpath())


          //  uye olundugunu test edelim
          // automationexercise.com
         // Automation Exercise
        // This is for automation practice
    }

    @Test
    public void olumsuzsenaryo(){

    }
}

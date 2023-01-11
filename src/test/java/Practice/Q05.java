package Practice;

import Utilities.ReusableMethods;
import com.sun.jna.Structure;
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
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Collection;
import java.util.List;

public class Q05 {

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
        Assert.assertEquals(expected,actual);

    }

    @After
    public void teardown(){

        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {

        // name ve email adress kismina bilgiler gondererek uye olalim
        WebElement nameBox= driver.findElement(By.xpath("//input[@type='text']"));
        nameBox.sendKeys("hasan");
        WebElement emailBox=driver.findElement(By.xpath("(//input[@type='email'])[2]"));
        emailBox.sendKeys("sacikara@gmail.com");
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        WebElement enterAccountText= driver.findElement(By.xpath("//*[text()='Enter Account Information']"));

      //  enterAccountText=driver.findElement(By.name("Enter Account Information"));
       // enterAccountText.sendKeys("enterAccountText" + Keys.ENTER);
        WebElement title=driver.findElement(By.xpath("//input[@id='id_gender1']"));
      //  title.sendKeys("title" + Keys.ENTER);
        title.click();

      //  WebElement name=driver.findElement(By.name("//input[@id='name']"));
      //  name.sendKeys("name" + Keys.ENTER);
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("password" + Keys.ENTER);

        WebElement day=driver.findElement(By.xpath("//select[@id='days']"));
        day.click();
        day.sendKeys("day" + Keys.ENTER);

        Select select= new Select(day);

        driver.findElement(By.xpath("//option[@value='24']")).click();

        WebElement montsh=driver.findElement(By.xpath("//select[@id='months']"));
        montsh.click();
        montsh.sendKeys("montsh" + Keys.ENTER);

        WebElement years=driver.findElement(By.xpath("//select[@id='years']"));
        years.click();
        years.sendKeys("years" + Keys.ENTER);

        WebElement signUpForTik=driver.findElement(By.xpath("//input[@id='newsletter']"));
        signUpForTik.click();

        WebElement checkbox1=driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkbox1.click();

        WebElement checkbox=driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkbox.click();
        checkbox.sendKeys("checkbox" + Keys.ENTER);

        WebElement checkbox2=driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        checkbox2.click();
        checkbox2.sendKeys("checkbox2" + Keys.ENTER);

       // driver.findElement(By.name("Address Information"));


       // WebElement firstName=driver.findElement(By.name("//input[@id='first_name']"));
       // firstName.sendKeys("firstName", " hasan " + Keys.ENTER);

        WebElement lastName=driver.findElement(By.name("//input[@id='last_name']"));
        lastName.sendKeys("lastName" , "sacikara" + Keys.ENTER);
        ReusableMethods.bekle(5);

        WebElement company=driver.findElement(By.xpath("//input[@id='company']"));
        company.sendKeys("company", " sacikara " + Keys.ENTER);
        WebElement address=driver.findElement(By.xpath("//input[@id='address1'][1]"));
        address.sendKeys("sacikaralar istanbul" + Keys.ENTER);



        WebElement country=driver.findElement(By.xpath("//select[@id='country']"));
        Select select1 = new Select(country);

        country.sendKeys("istanbul" + Keys.ENTER);

        WebElement state=driver.findElement(By.id("//input[@id='state']"));
        state.sendKeys("istanbul" + Keys.ENTER);
        WebElement city=driver.findElement(By.xpath("//input[@id='city']"));
        city.sendKeys("canada" + Keys.ENTER);


       WebElement zipCode=driver.findElement(By.xpath("//input[@id='zipcode']"));
       zipCode.sendKeys("34000" + Keys.ENTER);
        WebElement mobileNumber=driver.findElement(By.xpath("//input[@id='mobile_number']"));
        mobileNumber.sendKeys("2123585241" + Keys.ENTER);


       // WebElement createAccountButon=driver.findElement(By.xpath("//button[@data-qa='create-account']"));
       // createAccountButon.click();

        ReusableMethods.bekle(5);






        //  enterAccountText=driver.findElement(By.name("Enter Account Information"));
        // enterAccountText.sendKeys("enterAccountText" + Keys.ENTER);
        //  title.sendKeys("title" + Keys.ENTER);

    }

 }




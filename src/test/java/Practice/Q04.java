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
        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        //2. Username kutusuna “standard_user” yazdirin
        WebElement userName=driver.findElement(By.className("//input[@name='user-name']"));
        userName.click();
        System.out.println(userName);

        //3. Password kutusuna “secret_sauce” yazdirin
        WebElement password=driver.findElement(By.id("//input[@id='password']"));
        password.click();
        Assert.assertTrue(driver.getTitle().contains("test01"));

        System.out.println("secret_sauce : " + password);
        Assert.assertTrue(password.isSelected());

        //4. Login tusuna basin
        WebElement login=driver.findElement(By.xpath("//input[@id='login-button']"));
        login.click();
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement standartUser=driver.findElement(By.id("//div[@id='login_credentials']"));
        standartUser.click();

        //6. Add to Cart butonuna basin
        WebElement addToCard=driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        addToCard.click();
        //7. Alisveris sepetine tiklayin
        WebElement alisVerisSepeti=driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
        alisVerisSepeti.click();
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
       WebElement shoppingeGeriDönüş=driver.findElement(By.xpath("//button[@class='btn btn_secondary back btn_medium']"));
       shoppingeGeriDönüş.click();


        //9. Sayfayi kapatin
    }
}

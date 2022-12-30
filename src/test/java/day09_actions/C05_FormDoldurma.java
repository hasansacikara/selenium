package day09_actions;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C05_FormDoldurma extends TestBase {

    @Test
    public void test01(){
        // facevook sayfasına gidiniz
        driver.get("https://www.facebook.com/");

        driver.findElement(By.xpath("//a[@ class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        WebElement firsnameKutusu=driver.findElement(By.name("firstname"));

        Actions actions = new Actions(driver);
        Faker faker = new Faker();

        String mailAdresi=faker.internet().emailAddress();
       // String mailAdresi2=faker.internet().emailAddress();

        actions.click(firsnameKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(mailAdresi)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("23")
                .sendKeys(Keys.TAB)
                .sendKeys("mart")
                .sendKeys(Keys.TAB)
                .sendKeys("1992")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT).perform();

        WebElement signupButonu=driver.findElement(By.name("websubmit"));
        signupButonu.click();


        ReusableMethods.bekle(20);



    }
}

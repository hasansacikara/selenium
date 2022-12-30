package day09_actions;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03_MovToElement extends TestBase {

    @Test
    public void test01(){
        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
        // mouse’u bu menunun ustune getirin
        WebElement beklenecekElement=driver.findElement(By.id("nav-link-accountList"));
        Actions actions= new Actions(driver);
        actions.moveToElement(beklenecekElement).perform();
        ReusableMethods.bekle(5);


        //3- “Create a list” butonuna basin

        driver.findElement(By.xpath("//span[text()='Create a List']")).click();

        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        WebElement yourListElementi=driver.findElement(By.id("//span[text()='Create a List']"));

        Assert.assertTrue(yourListElementi.isDisplayed());


    }
}

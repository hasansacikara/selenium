package day09_actions;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class C01_MausActions extends TestBase {


    @Test
    public void test01(){
        //1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapin
        Actions actions= new Actions(driver);
        WebElement ciziliAlanElementi= driver.findElement(By.xpath("//div[@id='hot-spot']"));

        actions.contextClick(ciziliAlanElementi).perform();
        ReusableMethods.bekle(5);


        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlertYazisi="You selected a context menu";
        String actualAlertYazisi=driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim

        String ilkSayfaWDH=driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        Set<String> ikiSayfaninWHD = driver.getWindowHandles();

        String ikinciSayfaWHD="";

        for (String eachWHD: ikiSayfaninWHD
        ){
            if (!eachWHD.equals(ikinciSayfaWHD)){
                ikinciSayfaWHD=eachWHD;
            }
        }

        driver.switchTo().window(ikinciSayfaWHD);

        String expectedYeniSayfaYazi="Elemental Selenium";
        String actualYeniSayfaYazi= driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals(expectedYeniSayfaYazi,actualYeniSayfaYazi);


        ReusableMethods.bekle(5);
    }
}

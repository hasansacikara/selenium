package day13_writeExcel_ScreenShot;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class C06_JSExecutor extends TestBase {

    @Test
    public void test01(){

        // amazon anasayfasına gidiniz
        driver.get("https://www.amazon.com");
        // sell linkine js executor kullanarak click yapın

        WebElement sellLinki=driver.findElement(By.xpath("//a[text()='Gift Cards']"));

        JavascriptExecutor jse= (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click(); ",sellLinki);

        jse.executeScript("alert('bu is bu kadar')");

        ReusableMethods.bekle(5);

    }
}

package day11_seleniumwaits_cookies;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class C04_WebTables extends TestBase {

    @Test
    public void test() {

        //1.“https://www.amazon.com” adresine gidin
        driver.get("https://www.amazon.com");
        //2.Sayfanin en altina inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        //3.Web table tum body’sini yazdirin

        WebElement tümBODY = driver.findElement(By.xpath("//tbody"));

        //4.Web table’daki satir sayisinin 9 oldugunu test edin

        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertEquals(9, satirlarListesi.size());

        //5.Tum satirlari yazdirin

        System.out.println();

        for (WebElement eachRow : satirlarListesi
        ) {
            System.out.println(eachRow.getText());
        }
        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> ucuncuSatirSutunListesi = driver.findElements(By.xpath("//tbody/tr[3]/td"));
        Assert.assertEquals(13, ucuncuSatirSutunListesi.size());
        //7. 5.sutunu yazdirin

        List<WebElement> besinciSutunElementleri = driver.findElements(By.xpath("//tbody/tr/td[5]"));

        for (WebElement eachElement : besinciSutunElementleri
        ) {
            System.out.println(eachElement.getText());
        }
        //8.Satir ve sutun sayisini parametre olarak alip,
        // hucredeki bilgiyi döndüren bir method olusturun

        WebElement istenenDataElementi = getElement(3, 5);
        System.out.println(istenenDataElementi.getText());

        ReusableMethods.bekle(5);
    }

    private WebElement getElement(int satir, int sutun) {

        String dinamikXpath="//tbody/tr["+satir+"]/td["+sutun+"]";

        WebElement istenenElement=driver.findElement(By.xpath(dinamikXpath));

        return istenenElement;
    }
}


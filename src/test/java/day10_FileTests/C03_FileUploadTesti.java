package day10_FileTests;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C03_FileUploadTesti extends TestBase {

    @Test
    public void test01(){
        //1.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //2.chooseFile butonuna basalim
        //3.Yuklemek istediginiz dosyayi secelim.
        //4.Upload butonuna basalim.

        /*
        Bu görevi yapabilmek için chooseFile butonuna basıldıgında
        acilan bilgisayarimizdaki file dosyalarını click yapmamız gerekir
        ancak Selenium bilgisayarimizdaki dosyalari click yapamaz

        Bunun yerine şöyle bir çözüm üretilmiştir

        1- chooseFile butonunu Locate ediniz
        2- upload edilecek dosyanın dosya  yolunu olusturunuz
        3- chooseFile butonuna sendKeys ile dosya yolunu gönderiniz

        */

        WebElement chooseFileButonu= driver.findElement(By.xpath("//input[@id='file-upload']"));

        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\MerhabaJava.dosx";

        chooseFileButonu.sendKeys(dosyaYolu);



         // upload butonuna basınız

        driver.findElement(By.xpath("//*[@id='file-submit\']")).click();

        //5.“File Uploaded!” textinin goruntulendigini test edelim.

        WebElement fileUploadedElementi=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedElementi.isDisplayed());

        ReusableMethods.bekle(3);

    }
}

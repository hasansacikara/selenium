package day10_FileTests;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownloadTesti extends TestBase {

    @Test
    public void test01(){
        //2. https://the-internet.herokuapp.com/download adresine gidelim.

        driver.get(" https://the-internet.herokuapp.com/download");


        //3. Facebookd.png dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='Facebookd.png']")).click();
        ReusableMethods.bekle(5);
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        // test için öncelikle dosyanın indirildiginde doyaYolu ne olacak bunu olusturmalıyız

        String dosyaYolu= System.getProperty("user.home")+ "\\Downloads\\Facebookd.png";

        // Bir dosyanın bilgisayarımızda var oldugunu (exist) test etmek için
        // java daki files class'ından yardım alacagız

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));



    }

    @Test
    public void test02(){
        // Masaustunde Merhabajava.docx dosyasi oldugunu test edin
        // dinamik dosya yolu olusturalim
        String dosyaYolu= System.getProperty("user.home")+ "/Desktop/MerhabaJava.docx";
        // Assert edelim
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
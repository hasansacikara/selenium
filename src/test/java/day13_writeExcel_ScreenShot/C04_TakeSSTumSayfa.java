package day13_writeExcel_ScreenShot;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;

public class C04_TakeSSTumSayfa extends TestBase {

    @Test
    public void test01(){

        // wisequarter ana sayfaya gidin
        driver.get("https://www.wisequarter.com");
        // anasayfaya gittiginizi test edin
        String expectedUrl="wisequarter";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        // tum sayfa screenshot alin
        ReusableMethods.tumSayfaScreenshotCek(driver);
    }
}

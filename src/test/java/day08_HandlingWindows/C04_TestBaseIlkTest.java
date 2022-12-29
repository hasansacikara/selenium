package day08_HandlingWindows;

import Utilities.ReusableMethods;
import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;

public class C04_TestBaseIlkTest extends TestBase {

    @Test
    public void test01(){

        // amazon'a gidin

        driver.get("https://www.amazon.com");

        // amazon'a gittiginizi test edin

        String expectedKelime= "amazon";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedKelime));

        ReusableMethods.bekle(3);
    }
}

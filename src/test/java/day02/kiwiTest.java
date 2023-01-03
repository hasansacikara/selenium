package day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class kiwiTest {


        // https://www.kiwi.com sayfasina gidin
        // Cookies i reddedin
        // Sayfa basliginin "kiwi" icerdigini test edin
        // Sag ust kisimdan dil ve para birimi secenegini Turkiye ve TL olarak secin
        // Sectiginiz dil ve para birimini dogrulayin
        // Ucus secenegi olarak tek yon secelim
        // Kalkis ve varis boxlarini temizleyerek kalkis ve varis ulkesini kendimiz belirleyelim
        // Gidis tarihi kismina erisim saglayarak gidecegimiz gunu secelim ve booking i iptal edelim
        // Sadece aktarmasiz ucuslar olarak filtreleme yapalim ve en ucuz secenegine tiklayalim
        // Filtreleme yaptigimiz en ucuz ucusun fiyatini getirerek 5000 tl den kucuk oldgunu dogurlayalim
        WebDriver driver;
        String https="https://www.";

        @Before
        public void setUp(){

            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        @After
        public void tearDown(){
            driver.close();
        }

        @Test
        public void kiwiTest() throws InterruptedException {
            // https://www.kiwi.com sayfasina gidin
            driver.get(https+"kiwi.com");

            // Cookies i reddedin
            WebElement cookies= driver.findElement(By.xpath("(//div[text()='Reject all'])[2]"));
            cookies.click();

            // Sayfa basliginin "kiwi" icerdigini test edin
            Assert.assertTrue(driver.getTitle().contains("Kiwi"));

            // Sag ust kisimdan dil ve para birimi secenegini Turkiye ve TL olarak secin
            WebElement dilsecimi= driver.findElement(By.xpath("//*[text()='PLN']"));
            dilsecimi.click();
            WebElement selectWebElemeti= driver.findElement(By.xpath("//select[@data-test='LanguageSelect']"));
            Select select=new Select(selectWebElemeti);
            select.selectByValue("tr");

            WebElement currencyElementi=driver.findElement(By.xpath("//select[@data-test='CurrencySelect']"));
            Select select1=new Select(currencyElementi);
            select1.selectByVisibleText("Turkish lira - TRY");

            WebElement saveButton= driver.findElement(By.xpath("//button[@data-test='SubmitRegionalSettingsButton']"));
            saveButton.click();

            WebElement text= driver.findElement(By.xpath("//*[text()='TRY']"));
            Assert.assertTrue(text.getText().contains("TRY"));

            // Ucus secenegi olarak tek yon secelim
            WebElement tekYonMenu= driver.findElement(By.xpath("(//div[@class='ButtonPrimitiveContent__StyledButtonPrimitiveContent-sc-1r81o9a-0 ZYrQU'])[10]"));
            tekYonMenu.click();

            WebElement tekYon= driver.findElement(By.xpath("//a[@data-test='ModePopupOption-oneWay']"));
            tekYon.click();
            // Kalkis ve varis boxlarini temizleyerek kalkis ve varis ulkesini kendimiz belirleyelim

            WebElement defaultCloseCity= driver.findElement(By.xpath("//div[@data-test='PlacePickerInputPlace-close']"));
            defaultCloseCity.click();

            WebElement kalkisTextBox= driver.findElement(By.xpath("(//input[@data-test='SearchField-input'])[1]"));
            kalkisTextBox.sendKeys("Istanbul");
            driver.findElement(By.xpath("//*[text()='İstanbul, Türkiye']")).click();

            WebElement varisNoktasiBox= driver.findElement(By.xpath("(//input[@data-test='SearchField-input'])[2]"));
            varisNoktasiBox.sendKeys("Varsova");

            driver.findElement(By.xpath("//*[text()='Varşova, Polonya']")).click();

            // Gidis tarihi kismina erisim saglayarak gidecegimiz gunu secelim ve booking i iptal edelim
            driver.findElement(By.xpath("//input[@data-test='SearchFieldDateInput']")).click();
            Thread.sleep(4000);
            driver.findElement(By.xpath("//div[@data-value='2023-02-10']")).click();
            driver.findElement(By.xpath("//button[@data-test='SearchFormDoneButton']")).click();
            driver.findElement(By.xpath("//*[text()='Booking.com ile konaklama arayın']")).click();
            driver.findElement(By.xpath("//a[@data-test='LandingSearchButton']")).click();

            // Sadece aktarmasiz ucuslar olarak filtreleme yapalim ve en ucuz secenegine tiklayalim

            driver.findElement(By.xpath("(//div[@class='Radio__IconContainer-sc-crlwn1-1 ixtoRa'])[1]")).click();
            Thread.sleep(1500);
            driver.findElement(By.xpath("//*[text()='En ucuz']")).click();
            // Filtreleme yaptigimiz en ucuz ucusun fiyatini getirerek 5000 tl den kucuk oldgunu dogurlayalim
            WebElement fiyatText= driver.findElement(By.xpath("(//span[@class=' length-8'])[4]"));
            String fiyat=fiyatText.getText();
            System.out.println(fiyat);
            fiyat=fiyat.replaceAll(" TL","").replaceAll("\\.","");
            System.out.println(fiyat);

            Assert.assertTrue(Integer.parseInt(fiyat)<5000);


        }
    }




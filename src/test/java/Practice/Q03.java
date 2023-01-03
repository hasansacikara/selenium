package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q03 {

    //1. Tarayıcıyı başlatın
    //2. 'http://automationexercise.com' URL'sine gidin
    //3. Ana sayfanın başarıyla göründüğünü doğrulayın
    //4. 'Kaydol / Giriş Yap' düğmesine tıklayın
    //5. 'Yeni Kullanıcı Kaydı!'nı doğrulayın! görünür
    //6. Adı ve e-posta adresini girin
    //7. 'Kaydol' düğmesini tıklayın
    //8. 'HESAP BİLGİLERİNİ GİRİN' ifadesinin göründüğünü doğrulayın
    //9. Ayrıntıları doldurun: Unvan, Ad, E-posta, Parola, Doğum tarihi
    //10. 'Bültenimize kaydolun!' onay kutusunu seçin.
    //11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
    //12. Ayrıntıları doldurun: Ad, Soyad, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
    //13. 'Hesap Oluştur düğmesini' tıklayın
    //14. 'HESAP OLUŞTURULDU!' görünür
    //15. 'Devam Et' düğmesini tıklayın
    //16. "Kullanıcı adı olarak oturum açıldı" ifadesinin görünür olduğunu doğrulayın
    //17. 'Hesabı Sil' düğmesini tıklayın
    //18. 'HESAP SİLİNDİ!' görünür ve 'Devam Et' düğmesini tıklayın

    WebDriver driver;
    String https="https://www";
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void teardown(){

        driver.close();
    }

    @Test
    public void test01(){
        // 1 Amozana git
        driver.get("https://www.amazon.com/");

        // ara
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).click();

        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

        driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal'][1]")).click();

















    }
}

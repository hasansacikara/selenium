package day06_assertions;

import org.junit.Assert;
import org.junit.Test;

public class C02_Assertion {

    /*
    JUnit framework'u calistirilan testlerin passed veya failed olmasını raporlar
    Ancak raporlamanın dogru sonuc vermesi icin
    test'lerin Assert class'ındaki hazır method'larla yapılması gerekir

    Eger Assert class'ı kullanılmazsa
    JUnit kodların sorunsuz olarak çalısıp bittigini raporlar
    c01'de testlerin if-else ile yaptıgımız icin
    testler faıled olsa da kodlar sorunsuz calıkstıgı için
    testler yesil tik olarak isaretlendi

     */
    int P1yas=60;
    int P2yas=66;
    int P3yas=70;

    @Test
    public void test1(){
        // emekli yasi 65 olduguna göre
        // P2 nin emekli olabilecegini test edin

        Assert.assertTrue(P2yas>65);
    }

    @Test
    public void test2() {
        // emekli yasi 65 olduguna göre
        // P1 nin emekli olabilecegini test edin

        Assert.assertFalse(P1yas>65);

    }

    @Test
    public void test3() {
        // emekli yasi 65 olduguna göre
        // P3 nin emekli olabilecegini test edin

        Assert.assertFalse("Girilen yas 65'den kucuk olmadıgından emekli olabilir",P3yas>65);

    }
}

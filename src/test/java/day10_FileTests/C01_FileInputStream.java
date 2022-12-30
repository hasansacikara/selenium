package day10_FileTests;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

public class C01_FileInputStream {

    @Test
    public void test(){


        String dosyaYolu="C:\\Users\\dell\\Desktop\\MerhabaJava.docx";
        //  FileInputStream dosya=new FileInputStream(dosyaYolu);
        System.out.println(System.getProperty("user.dir")); // C:\Users\caglayan\IdeaProjects\com.Team105Selenium
        // o anca çalışan dosyanın (C01_FileInputStream) yolunu verir
        System.out.println(System.getProperty("user.home")); //C:\Users\caglayan
        //Kullanıcının temel path'ini verir.
        //Masaustune gitmek istersek
        ///Users/ahmetbulutluoz/IdeaProjects/com.Team105Junit
        //Dowloads'a gitmek istersek
        //User/ahmetbulutluoz+/Downloads eklememız yeterlidir
       /* Kodlarımızın dınamık olması yani kısının bılgısayarındakı kullanıcı adı gibi detaylara takılmaması için
       file testlerinde kullanılacak dosya yolunu "user.home" temel path'ini çalıştıgı bılgısayardan alacak sekılde olustururuz
        */
        String dinamikDosyaYolu=System.getProperty("user.home")+"\\Desktop\\MerhabaJava.docx";
    }
}

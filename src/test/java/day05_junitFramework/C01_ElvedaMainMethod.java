package day05_junitFramework;

import org.junit.Ignore;
import org.junit.Test;

public class C01_ElvedaMainMethod {

    @Test
    public void test1(){
        System.out.println("test01 calisti");
        //@Test notasyonu sayesinde her bir test method'u bagımsız olarak calisabilir
        // eger testin içersinde bir assertion (öne sürme) yoksa
        // kod problem yasanmadan calisip bittginde
        // JUnit test passed olarak raporlar

    }

    @Test @Ignore
    public void test2(){
        System.out.println("test02 calisti");
        // @Ignore notasyonu yazıldıgı test method'unun calistirilmamasini saglar.

    }

    @Test
    public void test3(){
        System.out.println("test03 calisti");

    }
}



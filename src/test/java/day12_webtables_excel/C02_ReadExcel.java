package day12_webtables_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {
        String dosyaYolu="src/test/java/day12_webtables_excel/ulkeler.xlsx";
        // FileInputStream objesi olusturup, parametre olarak yolunu yazınız
        FileInputStream fis = new FileInputStream(dosyaYolu);
        // Kod alanimizda excel'in bir kopyasini olusturup
        // tüm bilgileri ona kopyalayınız

        Workbook workbook = WorkbookFactory.create(fis);

        //workbook'un

        Sheet sheet = workbook.getSheet("Sayfa1");

        // Angola yazdırmak istedigimiz için 5. satira gidiniz

        Row row = sheet.getRow(5);

        // 5. satirda 2. index'deki datayı alınız

        Cell cell = row.getCell(2);

        System.out.println(cell);



    }
}

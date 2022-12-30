package day09_actions;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C02_DragAndDrop extends TestBase {

    @Test
    public void test01(){
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable ");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim

        WebElement dragMeElementi=driver.findElement(By.id("draggable"));
        WebElement birakikacakAlanElementi=driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(dragMeElementi,birakikacakAlanElementi).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        WebElement dropedYaziElementi=driver.findElement(By.xpath("//*[text()='Dropped!']"));

        Assert.assertTrue(dropedYaziElementi.isDisplayed());
    }
}

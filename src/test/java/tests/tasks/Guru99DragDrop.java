package tests.tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Guru99DragDrop {
    /*
    http://demo.guru99.com/test/drag_drop.html url e git
    DEBIT SIDE da Account bolumune BANK butonunu surukle ve birak
    CREDIT SIDE da Account bolumune SALES butonunu surukle ve birak
    DEBIT SIDE da Amount bolumune 5000 butonunu surukle ve birak
    CREDIT SIDE da Amount bolumune ise ikinci 5000  butonunu surukle ve birak
    Perfect butonun goruntulendigini dogrulayin
     */

    @Test
    public void test01() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //http://demo.guru99.com/test/drag_drop.html url e git
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        //DEBIT SIDE da Account bolumune BANK butonunu surukle ve birak
        //CREDIT SIDE da Account bolumune SALES butonunu surukle ve birak
        //DEBIT SIDE da Amount bolumune 5000 butonunu surukle ve birak
        //CREDIT SIDE da Amount bolumune ise ikinci 5000  butonunu surukle ve birak

        Actions actions = new Actions(driver);

        int[] butonArr = {5, 6, 2, 4};
        int[] sideArr = {1, 3, 2, 4};

        for (int i = 0; i < butonArr.length; i++) {
            WebElement butonElement = driver.findElement(By.xpath("//div[@id='products']/div//li[" + butonArr[i] + "]"));
            WebElement sideElement = driver.findElement(By.xpath("(//div[@class='shoppingCart']//div[1])[" + sideArr[i] + "]"));

            actions.dragAndDrop(butonElement, sideElement).perform();
        }

        //Perfect butonun goruntulendigini dogrulayin
        WebElement perfectButonuElement = driver.findElement(By.xpath("//div[@class='table4_result']/a"));
        Assert.assertTrue(perfectButonuElement.isDisplayed());

        //sayfayi kapat
        driver.close();
    }

}

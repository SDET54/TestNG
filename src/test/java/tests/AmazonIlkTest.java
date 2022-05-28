package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AmazonIlkTest {

    @Test
    public void test01() throws IOException {

        //amazon sayfasina git
        Driver.getDriver().get("https://www.amazon.com");

        //tum sayfa ekran goruntusu al
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String tarih = date.format(dtf);

        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File tumSayfaSS = new File("target/amazon/tumSayfaSS/screenShot" + tarih + ".jpeg");
        File temp = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp,tumSayfaSS);

        //arama kutusuna Laptop yaz ve ara
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusuElementi.sendKeys("Laptop" + Keys.ENTER);

        //arama sonucunun goruntulendigini test et
        Assert.assertTrue(amazonPage.aramaSonucElementi.isDisplayed());

        //arama sonucu yazisinin ekran goruntusunu al
        File aramaSonucSS = new File("target/amazon/aramaSonucSS/screenShot" + tarih + ".jpeg");
        temp = amazonPage.aramaSonucElementi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp, aramaSonucSS);

        //sayfayi kapat
        Driver.closeDriver();
    }
}

package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
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
        Driver.getDriver().get("https://www.amazon.com");

        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusuElementi.sendKeys("Laptop" + Keys.ENTER);

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String tarih = date.format(dtf);

        File aramaSonucSS = new File("target/amazon/aramaSonuc/screenShot" + tarih + ".jpeg");
        File temp = amazonPage.aramaSonucElementi.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(temp, aramaSonucSS);

        Driver.closeDriver();
    }
}

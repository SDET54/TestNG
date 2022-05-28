package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelmycampPage;
import utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HotelmycampPositiveTest {
    /*
    1) Bir Class olustur : HotelmycampPositiveTest
    2) Bir test method olustur positiveLoginTest()
         https://www.hotelmycamp.com/ adresine git
         login butonuna bas
         test data username: manager
         test data password : Manager1!
         Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
     */

    @Test
    public void positiveLoginTest() throws IOException {
        //      https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get("https://www.hotelmycamp.com");

        //      login butonuna bas
        HotelmycampPage hotelmycampPage = new HotelmycampPage();
        hotelmycampPage.ilkLoginTusuElementi.click();

        //      test data username: manager
        hotelmycampPage.userNameKutusuElementi.sendKeys("manager");

        //      test data password : Manager1!
        hotelmycampPage.passwordKutusuElementi.sendKeys("Manager1!");

        //      Degerleri girildiginde sayfaya basarili sekilde girilebildigini fotografli test et
        hotelmycampPage.girisLoginTusuElementi.click();

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(hotelmycampPage.usernameAfterLogin).perform();

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String tarih = date.format(dtf);

        File hotelmycampSS = new File("target/hotelmycamp/logOutElement" + tarih + ".jpeg");
        File temp = hotelmycampPage.logOutTusuElementi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp, hotelmycampSS);

        Assert.assertTrue(hotelmycampPage.logOutTusuElementi.isDisplayed());

        Driver.closeDriver();

    }
}

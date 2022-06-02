package tests.hotelMyCamp.smokeTest;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelmycampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PositiveTest {

    /*
    1) com.techproed altinda bir package olustur : smoketest
    2) Bir Class olustur: PositiveTest
    3) Bir test method olustur positiveLoginTest()
      https://www.hotelmycamp.com adresine git
      login butonuna bas
      test data username: manager
      test data password: Manager1!
      login butonuna bas
      Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
     */
    HotelmycampPage hotelmycampPage;

    @Test
    public void positiveLoginTest() {
        Driver.getDriver().get(ConfigReader.getProperty("hMcUrl"));
        Actions actions = new Actions(Driver.getDriver());
        hotelmycampPage = new HotelmycampPage();

        hotelmycampPage.ilkLoginTusuElementi.click();
        hotelmycampPage.userNameKutusuElementi.sendKeys(ConfigReader.getProperty("hMcUsername"));
        hotelmycampPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("hMcPassword"));
        hotelmycampPage.girisLoginTusuElementi.click();
        actions.moveToElement(hotelmycampPage.usernameAfterLogin).perform();

        Assert.assertTrue(hotelmycampPage.logOutTusuElementi.isDisplayed());

        Driver.closeDriver();
    }
}

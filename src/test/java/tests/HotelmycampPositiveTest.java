package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelmycampPage;
import utilities.Driver;

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
    public void positiveLoginTest() {
        //      https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get("https://www.hotelmycamp.com");

        //      login butonuna bas
        HotelmycampPage hotelmycampPage = new HotelmycampPage();
        hotelmycampPage.ilkLoginTusuElementi.click();

        //      test data username: manager
        hotelmycampPage.userNameKutusuElementi.sendKeys("manager");

        //      test data password : Manager1!
        hotelmycampPage.passwordKutusuElementi.sendKeys("Manager1!");

        //      Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        hotelmycampPage.girisLoginTusuElementi.click();

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(hotelmycampPage.usernameAfterLogin).perform();

        Assert.assertTrue(hotelmycampPage.logOutTusuElementi.isDisplayed());

        Driver.closeDriver();

    }
}

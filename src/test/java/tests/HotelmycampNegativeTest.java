package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelmycampPage;
import utilities.Driver;

public class HotelmycampNegativeTest {

    /*
    1 ) Bir Class olustur: HotelmycampNegativeTest
    2) Bir test method olustur negativeLoginTest()
          https://www.hotelmycamp.com/ adresine git
          login butonuna bas
          test data username: manager1
          test data password: manager1!
          Degerleri girildiginde sayfaya girilemedigini test et
     */

    @Test
    public void negativeLoginTest() {
        //https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get("https://www.hotelmycamp.com");

        //login butonuna bas
        HotelmycampPage hotelmycampPage = new HotelmycampPage();
        hotelmycampPage.ilkLoginTusuElementi.click();

        //test data username: manager1
        hotelmycampPage.userNameKutusuElementi.sendKeys("manager1");

        //test data password: manager1!
        hotelmycampPage.passwordKutusuElementi.sendKeys("manager1!");

        //Degerleri girildiginde sayfaya girilemedigini test et
        hotelmycampPage.girisLoginTusuElementi.click();

        Assert.assertTrue(hotelmycampPage.girisYapilamadiElementi.isDisplayed());

        Driver.closeDriver();

    }

}

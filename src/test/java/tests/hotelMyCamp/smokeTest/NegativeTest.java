package tests.hotelMyCamp.smokeTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelmycampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class NegativeTest {
    /*
    1) smoke T est paketi altinda yeni bir Class olustur: NegativeTest
        3 Farkli test Methodunda 3 senaryoyu test et
        -yanlisSifre
        -yanlisKulllanici
        -yanlisSifreKullanici
        test data yanlis username: manager1 ,
        yanlis password : manager1
2) https://www.hotelmycamp.com adresine git
3) Login butonuna bas
4) Verilen senaryolar ile giris yapilamadigini test et
     */

    HotelmycampPage hotelmycampPage;

    @BeforeMethod
    public void goToSite() {
        Driver.getDriver().get(ConfigReader.getProperty("hMcUrl"));
    }

    @AfterMethod
    public void closePage() {
        Driver.closeDriver();
    }

    @Test
    public void yanlisSifre() {
        hotelmycampPage = new HotelmycampPage();

        hotelmycampPage.ilkLoginTusuElementi.click();
        hotelmycampPage.userNameKutusuElementi.sendKeys(ConfigReader.getProperty("hMcUsername"));
        hotelmycampPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("hMcWrongPassword"));
        hotelmycampPage.girisLoginTusuElementi.click();
        Assert.assertTrue(hotelmycampPage.girisYapilamadiElementi.isDisplayed());
    }

    @Test
    public void yanlisKullanici() {
        hotelmycampPage = new HotelmycampPage();

        hotelmycampPage.ilkLoginTusuElementi.click();
        hotelmycampPage.userNameKutusuElementi.sendKeys(ConfigReader.getProperty("hMcWrongUsername"));
        hotelmycampPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("hMcPassword"));
        hotelmycampPage.girisLoginTusuElementi.click();
        Assert.assertTrue(hotelmycampPage.girisYapilamadiElementi.isDisplayed());

    }

    @Test
    public void yanlisSifreKullanici() {
        hotelmycampPage = new HotelmycampPage();

        hotelmycampPage.ilkLoginTusuElementi.click();
        hotelmycampPage.userNameKutusuElementi.sendKeys(ConfigReader.getProperty("hMcWrongUsername"));
        hotelmycampPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("hMcWrongPassword"));
        hotelmycampPage.girisLoginTusuElementi.click();
        Assert.assertTrue(hotelmycampPage.girisYapilamadiElementi.isDisplayed());
    }

}

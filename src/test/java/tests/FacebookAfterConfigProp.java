package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;


public class FacebookAfterConfigProp {

    @Test
    public void test01() {
        // facebook anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));

        // cikarsa cookies kabul edin
        // kullanici mail kutusuna rastgele bir isim yazdirin
        FacebookPage facebookPage = new FacebookPage();
        facebookPage.emailKutusuElementi.sendKeys(ConfigReader.getProperty("fbWrongUsername"));

        // kullanici sifre kutusuna rastgele bir password yazdirin
        facebookPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("fbWrongPassword"));

        // login butonuna basin
        facebookPage.loginButonuElementi.click();

        // giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.girisYapilamadiElementi.isDisplayed());

        // sayfayi kapat
        Driver.closeDriver();
    }
}

package tests.hotelMyCamp.e2ETest;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelmycampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class CreateHotel {
    /*
    1. Tests packagenin altına class olusturun: CreateHotel
    2. Bir metod olusturun: createHotel
    3. https://www.hotelmycamp.com adresine git
    4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri girin.
        a. Username: manager
        b. Password: Manager1!
    5. xLogin butonuna tıklayın.
    6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
    7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
    8. Save butonuna tıklayın.
    9. “Hotel was inserted successfully”textinin göründüğünü test edin.
    10. OK butonuna tıklayın.
     */

    @Test
    public void createHotel() throws InterruptedException {
        HotelmycampPage hotelmycampPage = new HotelmycampPage();

        //3. https://www.hotelmycamp.com adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hMcUrl"));
        hotelmycampPage.ilkLoginTusuElementi.click();

        //4. Username textbox ve password metin kutularını locate edin ve asagidaki verileri girin.
        //    a. Username: manager
        hotelmycampPage.userNameKutusuElementi.sendKeys(ConfigReader.getProperty("hMcUsername"));

        //    b. Password: Manager1!
        hotelmycampPage.passwordKutusuElementi.sendKeys(ConfigReader.getProperty("hMcPassword"));

        //5. xLogin butonuna tıklayın.
        hotelmycampPage.girisLoginTusuElementi.click();

        //6. Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
        hotelmycampPage.hotelManagementElementi.click();
        hotelmycampPage.hotelListElementi.click();
        hotelmycampPage.addHotelElementi.click();

        //7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        actions.
                click(hotelmycampPage.codeKutusuElementi).
                sendKeys(faker.number().digits(5)).
                sendKeys(Keys.TAB).
                sendKeys(faker.company().name()).
                sendKeys(Keys.TAB).
                sendKeys(faker.address().fullAddress()).
                sendKeys(Keys.TAB).
                sendKeys(faker.phoneNumber().phoneNumber()).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().emailAddress()).
                perform();

        Select select = new Select(hotelmycampPage.idGroupDdMElementi);
        select.selectByValue("1");

        //8. Save butonuna tıklayın.
        hotelmycampPage.saveButonuElementi.click();
        Thread.sleep(3000);

        //9. “Hotel was inserted successfully”textinin göründüğünü test edin.
        String actualTextAfterSave = hotelmycampPage.textAfterSaveElementi.getText();
        String expectedTextAfterSave = ConfigReader.getProperty("expectedTextAfterSave");

        Assert.assertEquals(actualTextAfterSave, expectedTextAfterSave);

        //10. OK butonuna tıklayın.
        hotelmycampPage.okButonuElementi.click();
        Thread.sleep(3000);

        //sayfayi kapat
        Driver.closeDriver();

    }
}

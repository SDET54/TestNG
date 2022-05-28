package tests.assertions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SoftAssertTesti extends TestBase {
    /*
 1. “http://zero.webappsecurity.com/” Adresine gidin
 2. Sign in butonuna basin
 3. Login kutusuna “username” yazin
 4. Password kutusuna “password” yazin
 5. Sign in tusuna basin
 6. Online banking menusu icinde Pay Bills sayfasina gidin
 7. “Purchase Foreign Currency” tusuna basin
 8. “Currency” drop down menusunden Eurozone’u secin
 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
 "Select One", "Australia (dollar)", "Canada (dollar)", "Switzerland (franc)", "China (yuan)", "Denmark (krone)",
 "Eurozone (euro)", "Great Britain (pound)", "Hong Kong (dollar)", "Japan (yen)", "Mexico (peso)", "Norway (krone)",
 "New Zealand (dollar)", "Sweden (krona)", "Singapore (dollar)", "Thailand (baht)"
     */

    @Test
    public void test01() {
        // 1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        // 2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();

        // 3. Login kutusuna “username” yazin
        // 4. Password kutusuna “password” yazin
        Actions actions = new Actions(driver);
        WebElement usernameKutusu = driver.findElement(By.id("user_login"));
        actions.
                click(usernameKutusu).
                sendKeys("username").
                sendKeys(Keys.TAB).
                sendKeys("password").
                perform();

        // 5. Sign in tusuna basin
        driver.findElement(By.name("submit")).click();

        //guvenlik protokulunden dolayi
        driver.navigate().back();

        // 6. Online banking menusu icinde Pay Bills sayfasina gidin
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("pay_bills_link")).click();


        // 7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//div[@id='tabs']//li[3]")).click();

        // 8. “Currency” drop down menusunden Eurozone’u secin
        WebElement currencyDdM = driver.findElement(By.id("pc_currency"));
        Select select = new Select(currencyDdM);
        select.selectByValue("EUR");

        // 9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
        String expectedSelection = "Eurozone (euro)";
        String actualSelection = select.getFirstSelectedOption().getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(expectedSelection, actualSelection, "belirtilen secenek aynisi degil");

        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        // "Select One", "Australia (dollar)", "Canada (dollar)", "Switzerland (franc)", "China (yuan)", "Denmark (krone)",
        // "Eurozone (euro)", "Great Britain (pound)", "Hong Kong (dollar)", "Japan (yen)", "Mexico (peso)", "Norway (krone)",
        // "New Zealand (dollar)", "Sweden (krona)", "Singapore (dollar)", "Thailand (baht)"
        List<String> expectedCurrencyDdMList = new ArrayList<>(Arrays.asList("Select One", "Australia (dollar)",
                "Canada (dollar)", "Switzerland (franc)", "China (yuan)", "Denmark (krone)", "Eurozone (euro)",
                "Great Britain (pound)", "Hong Kong (dollar)", "Japan (yen)", "Mexico (peso)", "Norway (krone)",
                "New Zealand (dollar)", "Sweden (krona)", "Singapore (dollar)", "Thailand (baht)"));

        List<WebElement> actualCurrencyDdMListElement = select.getOptions();
        List<String> actualCurrencyDdMListString = new ArrayList<>();
        for (WebElement webElement : actualCurrencyDdMListElement) {
            actualCurrencyDdMListString.add(webElement.getText());
        }

        Collections.sort(actualCurrencyDdMListString);
        Collections.sort(expectedCurrencyDdMList);

        softAssert.assertEquals(expectedCurrencyDdMList, actualCurrencyDdMListString, "Currency DdM ayni sonuclar cikmadi");

        softAssert.assertAll();

    }

}

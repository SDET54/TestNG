package tests.tasks;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TutorialsninjaPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TutorialsNinja {
    /*
    ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
    ~ click on Phones & PDAs
    ~ get the brandName of phones
    ~ click on add to button for all elements
    ~ click on black total added cart button
    ~ get the names of list from the cart
    ~ compare the names from displaying list and cart list
*/

    @Test
    public void test01() throws InterruptedException {
        //  ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        Driver.getDriver().get(ConfigReader.getProperty("tutorialsNinjaUrl"));

        //  ~ click on Phones & PDAs
        TutorialsninjaPage tutorialsninjaPage = new TutorialsninjaPage();
        tutorialsninjaPage.phonesPdaElement.click();

        //  ~ get the brandName of phones
        List<String> brandNameList = new ArrayList<>();
        for (int i = 0; i < tutorialsninjaPage.phoneBrandNameElements.size(); i++) {
            brandNameList.add(tutorialsninjaPage.phoneBrandNameElements.get(i).getText());
        }
        Collections.sort(brandNameList);


        //  ~ click on add to button for all elements
        for (WebElement each : tutorialsninjaPage.addToCartElements) {
            each.click();
        }

        Thread.sleep(3000);
        //  ~ click on black total added cart button
        tutorialsninjaPage.totalCartElement.click();

        //  ~ get the names of list from the cart
        List<String> totalCartBrandNameList = new ArrayList<>();
        for (int i = 0; i < tutorialsninjaPage.totalCartBrandNameElements.size(); i++) {
            totalCartBrandNameList.add(tutorialsninjaPage.totalCartBrandNameElements.get(i).getText());
        }
        Collections.sort(totalCartBrandNameList);

        //  ~ compare the names from displaying list and cart list
        Assert.assertTrue(brandNameList.containsAll(totalCartBrandNameList));

        Driver.closeDriver();
    }
}

package tests.tasks;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ReactPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestNGPageReact {

    // 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
    // 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
    // (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )
    // 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
    // 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
    // (Her ürün 1 defadan fazla eklenemez!)
    // 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
    // 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin
    // 7.Checkout'a tıklayın

    @Test
    public void test01() {
        // 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("reactUrl"));

        // 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
        // (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )

        ReactPage reactPage = new ReactPage();

        for (int i = 0; i < reactPage.productsElement.size(); i++) {
            System.out.println((i + 1) + ".urun : " + reactPage.productsElement.get(i).getText() + "\n");
        }

        // 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
        List<String> productNamesList = new ArrayList<>();
        for (WebElement each : reactPage.productNamesElement) {
            productNamesList.add(each.getText());
        }

        // 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
        // (Her ürün 1 defadan fazla eklenemez!)
        // 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
        // 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin


        Random rnd = new Random();
        List<Integer> randomIndexList = new ArrayList<>();

        int randomSelect = 5;

        while (randomIndexList.size() < randomSelect) {
            int randomIndex = rnd.nextInt(reactPage.addToCartButton.size());
            if (!randomIndexList.contains(randomIndex)) {
                randomIndexList.add(randomIndex);
            }
        }

        List<String> priceList = new ArrayList<>();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        double expectedTotalPrice = 0;
        for (int i = 0; i < randomSelect; i++) {
            js.executeScript("arguments[0].click();", reactPage.addToCartButton.get(randomIndexList.get(i)));

            System.out.println(productNamesList.get(randomIndexList.get(i)));
            priceList.add(reactPage.priceElement.get(randomIndexList.get(i)).getText().replace("$", ""));
            expectedTotalPrice += Double.parseDouble(priceList.get(i));
        }

        double actualTotalPrice = Double.parseDouble(reactPage.subtotalPriceElement.getText().replace("$", ""));

        NumberFormat numberFormat = new DecimalFormat("#0.00");
        expectedTotalPrice = Double.parseDouble(numberFormat.format(expectedTotalPrice));
        actualTotalPrice = Double.parseDouble(numberFormat.format(actualTotalPrice));

        Assert.assertEquals(actualTotalPrice, expectedTotalPrice);

        // 7.Checkout'a tıklayın
        reactPage.checkOutButtonElement.click();

        // sayfayi kapat

        Driver.closeDriver();

    }

}
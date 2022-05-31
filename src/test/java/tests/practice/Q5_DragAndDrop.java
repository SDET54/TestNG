package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class Q5_DragAndDrop {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        // Fill in capitals by country.
        List<WebElement> countryElementList = driver.findElements(By.xpath("//div[@id='countries']/div"));

        Actions actions = new Actions(driver);

        for (int i = 0; i < countryElementList.size(); i++) {
            WebElement cityElement = driver.findElement(By.xpath("//div[@id='box" + (i + 1) + "']"));

            for (WebElement webElement : countryElementList) {
                switch (cityElement.getText()) {
                    case "Oslo":
                        if (webElement.getText().equals("Norway")) {
                            actions.dragAndDrop(cityElement, webElement).perform();
                        }
                        break;
                    case "Washington":
                        if (webElement.getText().equals("United States")) {
                            actions.dragAndDrop(cityElement, webElement).perform();
                        }
                        break;
                    case "Copenhagen":
                        if (webElement.getText().equals("Denmark")) {
                            actions.dragAndDrop(cityElement, webElement).perform();
                        }
                        break;
                    case "Rome":
                        if (webElement.getText().equals("Italy")) {
                            actions.dragAndDrop(cityElement, webElement).perform();
                        }
                        break;
                    case "Madrid":
                        if (webElement.getText().equals("Spain")) {
                            actions.dragAndDrop(cityElement, webElement).perform();
                        }
                        break;
                    case "Seoul":
                        if (webElement.getText().equals("South Korea")) {
                            actions.dragAndDrop(cityElement, webElement).perform();
                        }
                        break;
                    case "Stockholm":
                        if (webElement.getText().equals("Sweden")) {
                            actions.dragAndDrop(cityElement, webElement).perform();
                        }
                        break;
                }
            }
        }
        driver.close();
    }

}



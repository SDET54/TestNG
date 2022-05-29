package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v101.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ReactPage {

    public ReactPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='sc-uhudcz-0 iZZGui']/div")
    public List<WebElement> productsElement;

    @FindBy(xpath = "//div[@class='sc-uhudcz-0 iZZGui']/div/p")
    public List<WebElement> productNamesElement;

    @FindBy(xpath = "//div[@class='sc-124al1g-5 fTQxRg']/p[1]")
    public List<WebElement> priceElement;

    @FindBy(xpath = "//button[@class='sc-124al1g-0 jCsgpZ']")
    public List<WebElement> addToCartButton;

    @FindBy(xpath = "//div[@class='sc-1h98xa9-8 bciIxg']/p[1]")
    public WebElement subtotalPriceElement;

    @FindBy(xpath = "//button[@class='sc-1h98xa9-11 gnXVNU']")
    public WebElement checkOutButtonElement;
}

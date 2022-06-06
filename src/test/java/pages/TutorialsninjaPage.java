package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TutorialsninjaPage {

    public TutorialsninjaPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Phones & PDAs']")
    public WebElement phonesPdaElement;

    @FindBy(xpath = "//div[@class='caption']//a")
    public List<WebElement> phoneBrandNameElements;

    @FindBy(xpath = "//*[text()='Add to Cart']")
    public List<WebElement> addToCartElements;

    @FindBy (xpath = "//div[@id='cart']")
    public WebElement totalCartElement;

    @FindBy(xpath = "//*[@id='cart']//table/tbody//td[2]/a")
    public List<WebElement> totalCartBrandNameElements;
}

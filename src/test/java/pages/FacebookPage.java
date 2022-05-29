package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "email")
    public WebElement emailKutusuElementi;

    @FindBy(id = "pass")
    public WebElement passwordKutusuElementi;

    @FindBy(name = "login")
    public WebElement loginButonuElementi;

    @FindBy(xpath = "//div[@class='_9ay7']")
    public WebElement girisYapilamadiElementi;


}

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BluerentalcarsPage {

    public BluerentalcarsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()=' Login']")
    public WebElement ilkLoginElement;

    @FindBy(xpath = "//input[@id='formBasicEmail']")
    public WebElement emailKutusuElement;

    @FindBy(xpath = "//input[@id='formBasicPassword']")
    public WebElement passwordKutusuElement;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement ikinciLoginElement;

    @FindBy(id = "dropdown-basic-button")
    public WebElement profilIsmiElement;

    @FindBy(xpath = "//*[text()='Create new user']")
    public WebElement createNewUserElement;

    @FindBy(tagName = "h1")
    public WebElement registerYazisiElement;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstNameKutusuElement;

    @FindBy(xpath = "//*[text()='You are registered successfully. ']")
    public WebElement basariliGirisYazisiElement;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement registerButtonElement;

}


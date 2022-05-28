package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HotelmycampPage {

    public HotelmycampPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "navLogon")
    public WebElement ilkLoginTusuElementi;

    @FindBy(id = "UserName")
    public WebElement userNameKutusuElementi;

    @FindBy(id = "Password")
    public WebElement passwordKutusuElementi;

    @FindBy(id = "btnSubmit")
    public WebElement girisLoginTusuElementi;

    @FindBy(xpath = "//li[@class='dropdown dropdown-user']")
    public WebElement usernameAfterLogin;

    @FindBy(xpath = "//a[text()=' Log out ']")
    public WebElement logOutTusuElementi;

    @FindBy(id = "divMessageResult")
    public WebElement girisYapilamadiElementi;
}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {
    @FindBy(xpath = "//a[contains(text(),'Sukurti naują paskyrą')]")
    private WebElement Register;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement SignIn;
    @FindBy(xpath = "//input[@placeholder='Prisijungimo vardas']")
    private WebElement InputUsername;
    @FindBy(xpath = "//input[@placeholder='Slaptažodis']")
    private WebElement InputPassword;
    @FindBy(xpath = "//span[contains(text(),'Įvestas prisijungimo vardas ir/ arba slaptažodis y')]")
    private WebElement InvalidLogInMessage;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    //loginui padarytas isankstinis useris
    public void setInputUsername() {
        InputUsername.sendKeys("Adminas");
    }

    public void setInputPassword() {
        InputPassword.sendKeys("Adminas");
    }

    public void clickSignIn() {
        SignIn.click();
    }

    public void invalidInputUsername() {
        InputUsername.sendKeys("A");
    }

    public void invalidInputPassword() {
        InputPassword.sendKeys("Ad");
    }

    public String InvalidLogInMessageError() {
        InvalidLogInMessage.getText();
        return InvalidLogInMessage.getText();
    }

    public void registerButton() {
        Register.click();
    }

}



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.UUID;

public class RegistrationPage extends BasePage {


    @FindBy(xpath = "//input[@id='username']")
    private WebElement UserUsername;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement UserPassword;

    @FindBy(xpath = "//input[@id='passwordConfirm']")
    private WebElement UserRepeatPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement ClickRegister;

    @FindBy(xpath = "//span[@id='username.errors']")
            private WebElement invalidUsernameError;
    @FindBy(xpath = "//span[@id='password.errors']")
    private WebElement invalidPasswordError;
    @FindBy(xpath = "//span[@id='passwordConfirm.errors']")
    private WebElement invalidConfirmPasswordError;

    int desiredLength = 15;
    String random = UUID.randomUUID().toString().substring(5,desiredLength);

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void validUserCreationName(){
        UserUsername.sendKeys(random);
    }

    public void validUserCreationPassword(){
        UserPassword.sendKeys("Userpassword");
    }

    public void validUserCreationPasswordRepeat(){
        UserRepeatPassword.sendKeys("Userpassword");
    }

    public void clickRegister(){
        ClickRegister.click();
    }
    public void invalidUserCreationName(){
        UserUsername.sendKeys("1");
    }

    public void invalidUserCreationPassword(){
        UserPassword.sendKeys("Us");
    }

    public void invalidUserCreationPasswordRepeat(){
        UserRepeatPassword.sendKeys("U");
    }
    public String RegisterInvalidTextUsername(){

        invalidUsernameError.getText();
        return invalidUsernameError.getText();
    }
    public String RegisterInvalidTextPassword(){

        invalidPasswordError.getText();
        return invalidPasswordError.getText();
    }
    public String RegisterInvalidTextConfirmPassword(){

        invalidConfirmPasswordError.getText();
        return invalidConfirmPasswordError.getText();
    }
}


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogsPage extends BasePage {

    @FindBy(xpath = "//a[normalize-space()='Keisti']")
    private WebElement edit;
    @FindBy(xpath = "//input[@name='sk1']")
    private WebElement firstNumber;
    @FindBy(xpath = "//input[@name='zenklas']")
    private WebElement symbol;
    @FindBy(xpath = "//input[@name='sk2']")
    private WebElement secondNumber;
    @FindBy(xpath = "//input[@name='rezult']")
    private WebElement result;
    @FindBy(xpath = "//input[@value='Atnaujinti']")
    private WebElement update;
    @FindBy(xpath = "//tbody/tr[2]/td[2]")
    private WebElement firstEditedNumber;
    @FindBy(xpath = "//tr[3]/td[2]")
    private WebElement symbolEdited;
    @FindBy(xpath = "//tr[4]/td[2]")
    private WebElement secondEditedNumber;
    @FindBy(xpath = "//tr[5]/td[2]")
    private WebElement resultEdited;

    @FindBy(xpath = "//a[@type='button']")
    private WebElement backButton;

    // @FindBy(xpath = "//td[5]/a[2]")
    // private WebElement deleteButton;
    @FindBy(xpath = "//h1[normalize-space()='Whitelabel Error Page']")
    private WebElement errorMessage;

    public LogsPage(WebDriver driver) {
        super(driver);
    }


    public void inputFirstNumber(String StringOne) {
        firstNumber.clear();
        firstNumber.sendKeys(StringOne);
    }

    public void setSymbol(String Symbol) {
        symbol.clear();
        symbol.sendKeys(Symbol);
    }

    public void inputSecondNumber(String numberTwo) {
        secondNumber.clear();
        secondNumber.sendKeys(numberTwo);
    }

    public void inputResult(String Result) {
        result.clear();
        result.sendKeys(Result);
    }

    public void ClickEdit() {
        edit.click();
    }

    public void clickUpdate() {
        update.click();
    }

    public void clickBack() {
        backButton.click();
    }
    //public void clickDelete(){
    // deleteButton.click();
    // }

    public String getFirstNumber() {
        firstEditedNumber.getText();
        return firstEditedNumber.getText();
    }

    public String getSecondNumber() {
        secondEditedNumber.getText();
        return secondEditedNumber.getText();
    }

    public String getEditedSymbol() {
        symbolEdited.getText();
        return symbolEdited.getText();
    }

    public String getEditedResult() {
        resultEdited.getText();
        return resultEdited.getText();
    }

    public String getErrorMessage() {
        errorMessage.getText();
        return errorMessage.getText();
    }

}

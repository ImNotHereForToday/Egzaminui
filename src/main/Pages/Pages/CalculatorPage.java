import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CalculatorPage extends BasePage {


    @FindBy(xpath = "//a[@class='navbar-brand']")
    private WebElement CalcPage;
    @FindBy(xpath = "//input[@id='sk1']")
    private WebElement inputFirstNumber;
    @FindBy(xpath = "//input[@id='sk2']")
    private WebElement inputSecondNumber;
    @FindBy(xpath = "//select[@name='zenklas']")
    private WebElement ClickSelect;
    @FindBy(xpath = "//*[@id=\"number\"]/select/option[1]")
    private WebElement selectPlus;
    @FindBy(xpath = "//*[@id=\"number\"]/select/option[2]")
    private WebElement selectMinus;
    @FindBy(xpath = "//*[@id=\"number\"]/select/option[3]")
    private WebElement selectMultiply;
    @FindBy(xpath = "//*[@id=\"number\"]/select/option[4]")
    private WebElement selectDivision;
    @FindBy(xpath = "//input[@value='skaičiuoti']")
    private WebElement clickCount;
    @FindBy(xpath = "//span[@id='sk1.errors']")
    private WebElement validationErrorBadCount;
    @FindBy(xpath = "//h4")
    private WebElement answerCheck;
    @FindBy(xpath = "//a[normalize-space()='Atliktos operacijos']")
    private WebElement goToLogs;

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public void insertFirstNumber(String number) {
        inputFirstNumber.clear();
        inputFirstNumber.sendKeys(number);
    }

    public void insertSecondNumber(String numberTwo) {
        inputSecondNumber.clear();
        inputSecondNumber.sendKeys(numberTwo);
    }

    public void chooseMathLabelMultiply() {
        Select objSelect = new Select(ClickSelect);
        objSelect.selectByVisibleText("Daugyba");
    }

    public void chooseMathLabelPlus() {
        Select objSelect = new Select(ClickSelect);
        objSelect.selectByVisibleText("Sudėtis");
    }

    public void chooseMathLabelMinus() {
        Select objSelect = new Select(ClickSelect);
        objSelect.selectByVisibleText("Atimtis");
    }

    public void chooseMathLabelDivide() {
        Select objSelect = new Select(ClickSelect);
        objSelect.selectByVisibleText("Dalyba");
    }

    public void pressCount() {
        clickCount.click();
    }

    public String AnswerPage() {
        answerCheck.getText();
        return answerCheck.getText();
    }

    public String CalculatorBasePage() {

        CalcPage.getText();
        return CalcPage.getText();
    }

    public String ValidationErrorMessage() {
        validationErrorBadCount.getText();
        return validationErrorBadCount.getText();
    }
    public void ClickGoToLogs(){
        goToLogs.click();
    }
}

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LogsTest extends baseTest {
    LogInPage loginPage;

    LogsPage logsPage;
    CalculatorPage calculatorPage;

    @Test
    void validCalculation() {
        loginPage = new LogInPage(driver);
        calculatorPage = new CalculatorPage(driver);
        logsPage = new LogsPage(driver);

        loginPage.setInputUsername();
        loginPage.setInputPassword();
        loginPage.clickSignIn();

        String expectedString = "Skaičiuotuvas";
        String actualString = calculatorPage.CalculatorBasePage();
        assertThat(actualString).isEqualTo(expectedString);


        calculatorPage.insertFirstNumber("2");
        calculatorPage.insertSecondNumber("2");
        calculatorPage.chooseMathLabelPlus();
        calculatorPage.pressCount();

        String expectedStringMultiply = "2 + 2 = 4";
        String actualStringMultiply = calculatorPage.AnswerPage();
        assertThat(actualStringMultiply).isEqualTo(expectedStringMultiply);

        calculatorPage.ClickGoToLogs();
        logsPage.ClickEdit();
        logsPage.inputFirstNumber("1");
        logsPage.setSymbol("/");
        logsPage.inputSecondNumber("1");
        logsPage.inputResult("0");
        logsPage.clickUpdate();

        String expectedStringFirstNumber = "1";
        String expectedStringSymbol = "/";
        String expectedStringSecondNumber = "1";
        String expectedStringResult = "0";

        String actualStringFirstNumber = logsPage.getFirstNumber();
        String actualStringSymbol = logsPage.getEditedSymbol();
        String actualStringSecondNumber = logsPage.getSecondNumber();
        String actualStringResult = logsPage.getEditedResult();

        assertThat(actualStringFirstNumber).isEqualTo(expectedStringFirstNumber);
        assertThat(actualStringSymbol).isEqualTo(expectedStringSymbol);
        assertThat(actualStringSecondNumber).isEqualTo(expectedStringSecondNumber);
        assertThat(actualStringResult).isEqualTo(expectedStringResult);
    }


    @Test
    void invalidCalculation() {
        loginPage = new LogInPage(driver);
        calculatorPage = new CalculatorPage(driver);
        logsPage = new LogsPage(driver);

        loginPage.setInputUsername();
        loginPage.setInputPassword();
        loginPage.clickSignIn();

        String expectedString = "Skaičiuotuvas";
        String actualString = calculatorPage.CalculatorBasePage();
        assertThat(actualString).isEqualTo(expectedString);


        calculatorPage.insertFirstNumber("2");
        calculatorPage.insertSecondNumber("2");
        calculatorPage.chooseMathLabelPlus();
        calculatorPage.pressCount();

        String expectedStringMultiply = "2 + 2 = 4";
        String actualStringMultiply = calculatorPage.AnswerPage();
        assertThat(actualStringMultiply).isEqualTo(expectedStringMultiply);

        calculatorPage.ClickGoToLogs();
        logsPage.ClickEdit();
        logsPage.inputFirstNumber("-1");
        logsPage.setSymbol("/");
        logsPage.inputSecondNumber("1");
        logsPage.inputResult("0");
        logsPage.clickUpdate();

        String expectedError = "Whitelabel Error Page";
        String actualError = logsPage.getErrorMessage();
        
        assertThat(actualError).isEqualTo(expectedError);
    }
}

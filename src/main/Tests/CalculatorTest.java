import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest extends baseTest {
    LogInPage loginPage;

    CalculatorPage calculatorPage;

    @Test
    void validCalculation() {
        loginPage = new LogInPage(driver);
        calculatorPage = new CalculatorPage(driver);

        loginPage.setInputUsername();
        loginPage.setInputPassword();
        loginPage.clickSignIn();

        String expectedString = "Skaičiuotuvas";
        String actualString = calculatorPage.CalculatorBasePage();
        assertThat(actualString).isEqualTo(expectedString);


        calculatorPage.insertFirstNumber("2");
        calculatorPage.insertSecondNumber("2");
        calculatorPage.chooseMathLabelMultiply();
        calculatorPage.pressCount();

        String expectedStringMultiply = "2 * 2 = 4";
        String actualStringMultiply = calculatorPage.AnswerPage();
        assertThat(actualStringMultiply).isEqualTo(expectedStringMultiply);
    }
    @Test
    void invalidCalculation(){
        loginPage = new LogInPage(driver);
        calculatorPage = new CalculatorPage(driver);

        loginPage.setInputUsername();
        loginPage.setInputPassword();
        loginPage.clickSignIn();

        String expectedString = "Skaičiuotuvas";
        String actualString = calculatorPage.CalculatorBasePage();
        assertThat(actualString).isEqualTo(expectedString);


        calculatorPage.insertFirstNumber("-1");
        calculatorPage.insertSecondNumber("2");
        calculatorPage.chooseMathLabelDivide();
        calculatorPage.pressCount();

        String expectedStringMultiply = "Validacijos klaida: skaičius negali būti neigiamas";
        String actualStringMultiply = calculatorPage.ValidationErrorMessage();
        assertThat(actualStringMultiply).isEqualTo(expectedStringMultiply);
    }

}

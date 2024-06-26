import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LogInTest extends baseTest {

    LogInPage loginPage;

    CalculatorPage calculatorPage;

    @Test
    void validLogIn() {
        loginPage = new LogInPage(driver);
        calculatorPage = new CalculatorPage(driver);

        loginPage.setInputUsername();
        loginPage.setInputPassword();
        loginPage.clickSignIn();

        String expectedString = "Skaičiuotuvas";
        String actualString = calculatorPage.CalculatorBasePage();
        assertThat(actualString).isEqualTo(expectedString);

    }

    @Test
    void invalidLogin() {
        loginPage = new LogInPage(driver);

        loginPage.invalidInputUsername();
        loginPage.invalidInputPassword();
        loginPage.clickSignIn();

        String expectedString = "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi";
        String actualString= loginPage.InvalidLogInMessageError();
        assertThat(actualString).isEqualTo(expectedString);

    }
}
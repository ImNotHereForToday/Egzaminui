import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RegistrationTest extends baseTest {

    RegistrationPage registrationPage;

    LogInPage loginPage;

    CalculatorPage calculatorPage;

    @Test
    void validUserCreation() {
        loginPage = new LogInPage(driver);
        registrationPage = new RegistrationPage(driver);
        calculatorPage = new CalculatorPage(driver);


        loginPage.registerButton();
        registrationPage.validUserCreationName();
        registrationPage.validUserCreationPassword();
        registrationPage.validUserCreationPasswordRepeat();
        registrationPage.clickRegister();

        String expectedString = "Skaičiuotuvas";
        String actualString = calculatorPage.CalculatorBasePage();
        assertThat(actualString).isEqualTo(expectedString);


    }

    @Test
    void invalidUserCreation() {

        loginPage = new LogInPage(driver);
        registrationPage = new RegistrationPage(driver);
        calculatorPage = new CalculatorPage(driver);

        loginPage.registerButton();
        registrationPage.invalidUserCreationName();
        registrationPage.invalidUserCreationPassword();
        registrationPage.invalidUserCreationPasswordRepeat();
        registrationPage.clickRegister();

        String expectedStringUsername = "Privaloma įvesti nuo 3 iki 32 simbolių";
        String expectedStringPassword = "Privaloma įvesti bent 3 simbolius";
        String expectedStringConfirmPassword = "Įvesti slaptažodžiai nesutampa";

        String actualStringUsername = registrationPage.RegisterInvalidTextUsername();
        String actualStringPassword = registrationPage.RegisterInvalidTextPassword();
        String actualStringConfirmPassword = registrationPage.RegisterInvalidTextConfirmPassword();

        assertThat(actualStringUsername).isEqualTo(expectedStringUsername);
        assertThat(actualStringPassword).isEqualTo(expectedStringPassword);
        assertThat(actualStringConfirmPassword).isEqualTo(expectedStringConfirmPassword);

    }

}

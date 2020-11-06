package tests;

import common.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.isChrome;

public class LoginTests extends BaseTest {


    @DataProvider(name = "login-alerts")
    public Object[][] loginProvider() {
        return new Object[][]{
                {"klebernascimento@outlook.com.br", "123456", "Usuário e/ou senha inválidos"},
                {"404@404.com", "pwd123", "Usuário e/ou senha inválidos"},
                {"klebernascimento@outlook.com.br", "", "Opps. Cadê a senha?"},
                {"", "pwd123", "Opps. Cadê o email?"}
        };
    }



    @Test
    public void shouldSeeLoggedUser() {
        login
                .open()
                .with("klebernascimento@outlook.com.br", "pwd123");
        // Validação
        side.loggedUser().shouldHave(text("Kleber"));
    }

    // DDT (Data Driven Testing)
    @Test(dataProvider = "login-alerts")
    public void shouldSeeLoginAlerts(String email, String pass, String expectAlert) {
        isChrome();

        executeJavaScript("localStorage.clear()");
        open("http://ninjaplus-web:5000");

        login
                .open()
                .with(email, pass)
                .alert().shouldHave(text(expectAlert));
    }

    @AfterMethod
    public void cleanUp() {
        login.clearSession();
    }
}
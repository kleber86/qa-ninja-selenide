import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.isChrome;

public class LoginTests {

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
        isChrome();
        open("http://ninjaplus-web:5000");

        $("input[name=email]").setValue("klebernascimento@outlook.com.br");
        $("#passId").setValue("pwd123");
        $(byText("Entrar")).click();

        // Validação
        $(".user .info span").shouldHave(text("Kleber"));
    }

    // DDT (Data Driven Testing)
    @Test(dataProvider = "login-alerts")
    public void shouldSeeLoginAlerts(String email, String pass, String expectAlert) {
        isChrome();

        executeJavaScript("localStorage.clear()");
        open("http://ninjaplus-web:5000");

        $("input[name=email]").setValue(email);
        $("#passId").setValue(pass);
        $(byText("Entrar")).click();

        $(".alert span").shouldHave(text(expectAlert));
    }
}
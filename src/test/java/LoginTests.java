import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.isChrome;

public class LoginTests {

    @Test
    public void shouldSeeLoggedUser(){
        isChrome();
        open("http://ninjaplus-web:5000");

        $("input[name=email]").setValue("klebernascimento@outlook.com.br");
        $("#passId").setValue("pwd123");
        $(byText("Entrar")).click();

        // Validação
        $(".user .info span").shouldHave(text("Kleber"));
    }
}

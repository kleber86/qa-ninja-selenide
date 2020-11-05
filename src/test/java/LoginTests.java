import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
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
        clearBrowserLocalStorage();
    }

    @Test
    public void incorrectPassword(){
        isChrome();
        open("http://ninjaplus-web:5000");

        $("input[name=email]").setValue("klebernascimento@outlook.com.br");
        $("#passId").setValue("000000");
        $(byText("Entrar")).click();

        $(".alert span").shouldHave(text("Usuário e/ou senha inválidos"));
    }

    @Test
    public void userNotFound(){
        isChrome();
        open("http://ninjaplus-web:5000");

        $("input[name=email]").setValue("404@404.com");
        $("#passId").setValue("pwd123");
        $(byText("Entrar")).click();

        $(".alert span").shouldHave(text("Usuário e/ou senha inválidos"));
    }

    @Test
    public void emailRequired(){
        isChrome();
        open("http://ninjaplus-web:5000");

        $("input[name=email]").setValue("");
        $("#passId").setValue("pwd123");
        $(byText("Entrar")).click();

        $(".alert span").shouldHave(text("Opps. Cadê o email?"));

    }

    @Test
    public void passwordRequired(){
        isChrome();
        open("http://ninjaplus-web:5000");

        $("#emailId").setValue("klebernascimento@outlook.com.br");
        $("#passId").setValue("");
        $(byText("Entrar")).click();

        $(".alert span").shouldHave(text("Opps. Cadê a senha?"));
    }
}

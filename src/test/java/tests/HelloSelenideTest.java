package tests;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.isChrome;
import static org.testng.AssertJUnit.assertEquals;

public class HelloSelenideTest {

    @Test
    public void OnAir() {
        isChrome();
        open("http://ninjaplus-web:5000/login");
        assertEquals(title(), "Ninja+");
    }

    @Test
    public void acessaGoogle() {
        isChrome();
        open("https://www.google.com.br/");
        assertEquals(title(), "Google");
    }

    @Test
    public void acessaGlobo() {
        isChrome();
        open("https://www.globo.com/");
        assertEquals(title(), "globo.com - Absolutamente tudo sobre notícias, esportes e entretenimento");
    }

    @Test
    public void acessaUol() {
        isChrome();
        open("https://www.uol.com.br/");
        assertEquals(title(), "UOL - O melhor conteúdo");
    }

}

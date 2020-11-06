package tests;

import common.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;

public class MovieTests extends BaseTest {


    @BeforeMethod
    public void setup() {
        login
                .open()
                .with("klebernascimento@outlook.com.br", "pwd123");

        side.loggedUser().shouldHave(text("Kleber"));
    }

    @Test
    public void shouldRegisterANewMovie() {
        String title = "Jumanji - Proxima Fase";

        movie.add().create(title);
    }
}

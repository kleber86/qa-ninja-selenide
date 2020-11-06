package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MoviePage;
import pages.SideBar;

import static com.codeborne.selenide.Condition.text;

public class MovieTests {

    private static LoginPage login;
    private static SideBar side;
    private static MoviePage movie;

    @BeforeMethod
    public void setup(){
        Configuration.browser = "chrome";
        Configuration.baseUrl = "http://ninjaplus-web:5000";

        login = new LoginPage();
        side = new SideBar();
        movie = new MoviePage();

        login
                .open()
                .with("klebernascimento@outlook.com.br", "pwd123");

        side.loggedUser().shouldHave(text("Kleber"));
    }

    @Test
    public void shouldRegisterANewMovie(){
        String title = "Jumanji - Proxima Fase";

        movie.add().create(title);
    }
}

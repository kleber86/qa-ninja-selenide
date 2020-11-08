package tests;

import common.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

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
        String status = "Pré-venda";
        String year = "2020";
        String releasesDate = "16/01/2020";
        List<String> cast = Arrays.asList("The Rock", "Jack Black", "Kevin Hart", "Karen Gillian", "Danny DeVito");
        String plot = "Lorem Ipsum is simply dummy text of the printing and typesetting " +
                "industry. Lorem Ipsum has been the industry's standard dummy text ever " +
                "since the 1500s.";

        movie.add().create(title, status, year, releasesDate, cast, plot);
    }
}

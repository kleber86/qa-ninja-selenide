package tests;

import libs.DataBase;
import common.BaseTest;
import libs.DataBase;
import model.MovieModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

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

        MovieModel movieModel = new MovieModel(
                "Jumanji - Proxima Fase",
                "Pré-venda",
                2020,
                "16/01/2020",
                Arrays.asList("The Rock", "Jack Black", "Kevin Hart", "Karen Gillian", "Danny DeVito"),
                "Lorem Ipsum is simply dummy text of the printing and typesetting " +
                        "industry. Lorem Ipsum has been the industry's standard dummy text ever " +
                        "since the 1500s.",
                "/jumanji.jpg"
        );

        DataBase dataBase = new DataBase();
        dataBase.deleteMovie(movieModel.title);

        movie
                .add()
                .create(movieModel)
                .items().findBy(text(movieModel.title)).shouldBe(visible);
    }
}

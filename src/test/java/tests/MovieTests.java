package tests;

import libs.DataBase;
import common.BaseTest;
import model.MovieModel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class MovieTests extends BaseTest {


    private DataBase dataBase;

    @BeforeMethod
    public void setup() {
        login
                .open()
                .with("klebernascimento@outlook.com.br", "pwd123");

        side.loggedUser().shouldHave(text("Kleber"));
    }

    @BeforeSuite
    public void delorean(){
        dataBase = new DataBase();
        dataBase.resetMovies();
    }

    @Test
    public void shouldRegisterANewMovie() {

        MovieModel movieModel = new MovieModel(
                "Avengers",
                "Pré-venda",
                2012,
                "16/01/2012",
                Arrays.asList("Robert Downey, Jr", "Chris Evans", "Scarlett Johansson", "Jeremy Renner"),
                "Lorem Ipsum is simply dummy text of the printing and typesetting " +
                        "industry. Lorem Ipsum has been the industry's standard dummy text ever " +
                        "since the 1500s.",
                "/avengers.jpg"
        );

        movie
                .add()
                .create(movieModel)
                .items().findBy(text(movieModel.title)).shouldBe(visible);
    }


    @Test
    public void shouldReturnTwoMovie(){
        movie.search("Batman").items().shouldHaveSize(2);
    }

    @AfterMethod
    public void cleanUp() { login.clearSession(); }
}

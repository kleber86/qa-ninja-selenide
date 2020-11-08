package pages;

import com.codeborne.selenide.SelenideElement;
import model.MovieModel;
import org.openqa.selenium.Keys;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MoviePage {

    public MoviePage add(){
        $(".movie-add").click();
        return this;
    }

    public MoviePage create(MovieModel movie){
        $("input[name=title]").setValue(movie.title);
        this.selectStatus(movie.status);
        $("input[name=year]").setValue(String.valueOf(movie.year));
        $("input[name=release_date]").setValue(movie.releaseDate);
        this.input(movie.cast);
        $("textarea[name=overview]").setValue(movie.plot);

        return this;
    }

    private void input(List<String> cast){
        SelenideElement element =  $(".cast");
        for(String actor : cast){
            element.setValue(actor).sendKeys(Keys.TAB);
        }
    }

    private void selectStatus(String status){
        $("input[placeholder=Status]").click();
        $$("ul li span").findBy(text(status)).click();
    }
}

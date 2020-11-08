package pages;

import com.codeborne.selenide.SelenideElement;
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

    public MoviePage create(String title, String status, String year, String releaseDate, List<String> cast, String plot){
        $("input[name=title]").setValue(title);
        this.selectStatus(status);
        $("input[name=year]").setValue(year);
        $("input[name=release_date]").setValue(releaseDate);
        this.input(cast);
        $("textarea[name=overview]").setValue(plot);

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

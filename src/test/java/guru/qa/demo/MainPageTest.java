package guru.qa.demo;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class MainPageTest extends BaseTest{


    @Test
    public void search() {


        open("https://gismeteo.ru");
        $(".search-label").click();
        $("[type=search]").setValue("Пятигорск");
        $(".city-text").shouldBe(text("Россия, Ставропольский край, Пятигорск (городской округ)")).click();

    }


}

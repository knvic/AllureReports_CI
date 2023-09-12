package guru.qa.demo;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;


public class SimpleSelenideStyleTest extends BaseTest{
    @Test
    void name() {
        open("https://github.com");
        $(".search-input").click();
        $("#query-builder-test").sendKeys(REPOSITORY);
        $("#query-builder-test").submit();
        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText("#" + ISSUE)).should(Condition.exist);
    }
}

package guru.qa.alluretests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;


public class SimpleSelenideStyleTest extends BaseTest{

    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("krivorotovnv")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com")
    @DisplayName("Создание Issue для авторизованного пользователя с помощью чистого Selenide")
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

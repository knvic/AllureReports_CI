package guru.qa.alluretests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class StepStyleTest extends BaseTest {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий {REPOSITORY}")
    public void searchRepository(String REPOSITORY) {
        $(".search-input").click();
        $("#query-builder-test").sendKeys(REPOSITORY);
        $("#query-builder-test").submit();
    }

    @Step("Кликаем по ссылке репозитория {repo}")
    public void clickOnRepository(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Открываем таб Issues")
    public void openIssues() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue с номером {issue}")
    public void checkIssueWithNumber(int issue) {
        $(withText("#" + issue)).should(Condition.exist);
    }


    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("krivorotovnv")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://github.com")
    @DisplayName("Поиск Issue для авторизованного пользователя с помощью annotated Steps")
    @Test
    void webStepTest() {
        openMainPage();
        searchRepository(REPOSITORY);
        clickOnRepository(REPOSITORY);
        openIssues();
        checkIssueWithNumber(ISSUE);
    }
}

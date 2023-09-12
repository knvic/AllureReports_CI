package guru.qa.demo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    public static final String REPOSITORY = "spring-projects/spring-boot";
    public static final int ISSUE = 37258;
    @BeforeAll
    static void beforeAll() {
        //SelenideLogger.addListener("Allure", new AllureSelenide());

        System.setProperty("webdriver.chrome.driver", "C:\\QA\\chromedriver-win64\\chromedriver-win64_116\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "D:\\Dev\\QA\\chromedriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen=true;
    }
}

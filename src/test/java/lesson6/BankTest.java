package lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BankTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private LoginPage loginPage;
    private LogOutPage logoutPage;
    private AboutPage aboutPage;
    private ForumPage forumPage;
    private AccountStatPage accountStatPage;
    private AboutIconPage aboutIconPage;

    private final String loginTestAssertUrl = "https://parabank.parasoft.com/parabank/overview.htm";
    private final String logoutTestAssertUrl = "https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC";
    private final String aboutTestAssertUrl = "https://parabank.parasoft.com/parabank/about.htm";


    @BeforeAll
    static void regDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);


        driver.get("https://parabank.parasoft.com/");
    }

    @Test
        //1 тест на логин
    void LoginTest() {
        loginPage = new LoginPage(driver);
        loginPage.TypeLogin()
            .TypePassword()
            .PressLoginButton();
        Assertions.assertTrue(driver.getCurrentUrl().contains(loginTestAssertUrl));
    }

    @Test //2 тест на логаут
    void LogOutTest() {
        LoginTest();

        logoutPage = new LogOutPage(driver);
        logoutPage.ClickLogout();
        Assertions.assertTrue(driver.getCurrentUrl().contains(logoutTestAssertUrl));
    }

    @Test //3 тест на клик по инфо про компанию
    void AboutUsInfo() {
        aboutPage = new AboutPage(driver);
        aboutPage.ClickAbout();
        Assertions.assertTrue(driver.getCurrentUrl().contains(aboutTestAssertUrl));
    }

    @Test //4 тест на открытие форума и поиска через поисковик
    void ForumInfo() {
        String inputText = "money";
        forumPage = new ForumPage(driver, inputText);
        forumPage.ClickForumButton();

        Assertions.assertTrue(driver.getCurrentUrl().contains("https://forums.parasoft.com/"));
        forumPage.TypeSearchText()
                .ClickSearchButton();

        Assertions.assertTrue(driver.getCurrentUrl().contains("https://forums.parasoft.com/search?query=" + inputText + "&scope=site&source=community"));
    }

    @Test //5 тест на запрос статы по аккаунту за январь по дебету
    void AccountStatistics() {
        LoginTest();
        accountStatPage = new AccountStatPage(driver);
        accountStatPage.FirstAccountGet()
                        .SelectMonth()
                        .SelectType();
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://parabank.parasoft.com/parabank/activity.htm?id=" + accountStatPage.number));
    }

    @Test //6 тест на открытие about через иконку
    void AboutIcon() {
        aboutIconPage = new AboutIconPage(driver);
        aboutIconPage.ClickAboutIcon();
        Assertions.assertTrue(driver.getCurrentUrl().contains(aboutTestAssertUrl));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
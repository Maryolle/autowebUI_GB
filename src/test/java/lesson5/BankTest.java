package lesson5;

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

    @Test //1 тест на логин
    void LoginTest() {
        WebElement Login = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input"));
        Login.click();
        Login.sendKeys("john");
        WebElement Password = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input"));
        Password.click();
        Password.sendKeys("demo");
        WebElement LogButton = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input"));
        LogButton.click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://parabank.parasoft.com/parabank/overview.htm"));
    }

    @Test //2 тест на логаут
    void LogOutTest() {
        WebElement Login = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input"));
        Login.click();
        Login.sendKeys("john");
        WebElement Password = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input"));
        Password.click();
        Password.sendKeys("demo");
        WebElement LogButton = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input"));
        LogButton.click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://parabank.parasoft.com/parabank/overview.htm"));

        WebElement LogOutButton = driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[8]/a"));
        LogOutButton.click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC"));
    }

    @Test //3 тест на клик по инфо про компанию
    void AboutUsInfo() {
        WebElement AboutUs = driver.findElement(By.xpath("/html/body/div[1]/div[2]/ul[1]/li[2]/a"));
        AboutUs.click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://parabank.parasoft.com/parabank/about.htm"));
    }

    @Test //4 тест на открытие форума и тест поисковика
    void ForumInfo() {
        WebElement Forum = driver.findElement(By.xpath("/html/body/div[2]/div/ul[1]/li[6]/a"));
        Forum.click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://forums.parasoft.com/"));
        WebElement SearchBar = driver.findElement(By.xpath("//*[@id=\"search-0-searchInput\"]"));
        SearchBar.sendKeys("money");
        WebElement SearchButton = driver.findElement(By.xpath("//*[@id=\"search-0-searchButton\"]"));
        SearchButton.click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://forums.parasoft.com/search?query=money&scope=site&source=community"));
    }

    @Test //5 тест на запрос статы по аккаунту 12345
    void AccountStatistics() {
        WebElement Login = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input"));
        Login.click();
        Login.sendKeys("john");
        WebElement Password = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input"));
        Password.click();
        Password.sendKeys("demo");
        WebElement LogButton = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input"));
        LogButton.click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://parabank.parasoft.com/parabank/overview.htm"));
        WebElement FirstAccount = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a")));
        //WebElement FirstAccount = driver.findElement(By.xpath("//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a"));
        String number = FirstAccount.getText();
        FirstAccount.click();

        WebElement SelectMonth = driver.findElement(By.xpath("//*[@id=\"month\"]/option[2]"));
        SelectMonth.click();
        WebElement GetStatistics = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div[2]/form/table/tbody/tr[3]/td[2]/input"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://parabank.parasoft.com/parabank/activity.htm?id=" + number));
    }

    @Test //6 тест на открытие about через иконку
    void AboutIcon() {
        WebElement AboutIcon = driver.findElement(By.xpath("//*[@id=\"headerPanel\"]/ul[2]/li[2]/a"));
        AboutIcon.click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("https://parabank.parasoft.com/parabank/about.htm"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
    }
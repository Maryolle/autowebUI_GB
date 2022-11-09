package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class MarketTest {
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
        driver.get("http://automationpractice.com");
    }

    @Test
    void ShopAddToCartTest() {
        WebElement clickTshirt = driver.findElement(By.xpath("(//a[contains(text(),'T-shirts')])[2]"));
        clickTshirt.click();
        WebElement buttonAdd = driver.findElement(By.xpath("//li[contains(@class,'ajax')]"));
        buttonAdd.click();
        WebElement clickAdd = driver.findElement(By.cssSelector("css=.ajax_add_to_cart_button > span"));
        clickAdd.click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("automation"));
    }

    @Test
    void AddToCartFromProduct() {
        WebElement clickTshirt = driver.findElement(By.xpath("(//a[contains(text(),'T-shirts')])[2]"));
        clickTshirt.click();
        WebElement buttonAdd = driver.findElement(By.xpath("//li[contains(@class,'ajax')]"));
        buttonAdd.click();
        WebElement clickMore = driver.findElement(By.xpath("//span[.='More']"));
        clickMore.click();
        WebElement clickAddToCart = driver.findElement(By.xpath("//span[.='Add to cart']"));
        clickAddToCart.click();
    }

    @Test
    void Auth() {
        WebElement findLogin = driver.findElement(By.xpath("//a[contains(@class,'login')]"));
        findLogin.click();
        WebElement LoginBar = driver.findElement(By.cssSelector("css=.form-group:nth-child(2)")); // глянь мб нужно часть с css= убрать тупо
        LoginBar.click();
        WebElement LoginBarEmail = driver.findElement(By.id("email"));
        LoginBarEmail.sendKeys("test.maryolle@yandex.ru");
        LoginBar.click();
        WebElement LoginBarPassword = driver.findElement(By.id("passwd"));
        LoginBarPassword.click();
        LoginBarPassword.sendKeys("testpass");
        LoginBar.click(); // перепроверь зачем этот клик лол
        WebElement SubmitLogin = driver.findElement(By.cssSelector("css=#SubmitLogin > span")); // глянь мб нужно часть с css= убрать тупо
        SubmitLogin.click();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
    }
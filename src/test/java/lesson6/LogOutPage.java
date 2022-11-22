package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogOutPage {
    WebDriver driver;

    private final String LogOutButtonXpath = "//*[@id=\"leftPanel\"]/ul/li[8]/a";

    public LogOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public LogOutPage ClickLogout(){
        WebElement LogOutButton = driver.findElement(By.xpath(LogOutButtonXpath));
        LogOutButton.click();
        return this;
    }
}

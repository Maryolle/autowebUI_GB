package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutIconPage {
    WebDriver driver;

    private final String AboutIconXpath = "//*[@id=\"headerPanel\"]/ul[2]/li[2]/a";


    public AboutIconPage(WebDriver driver) {
        this.driver = driver;
    }

    public AboutIconPage ClickAboutIcon(){
        WebElement AboutIcon = driver.findElement(By.xpath(AboutIconXpath));
        AboutIcon.click();
        return this;
    }
}

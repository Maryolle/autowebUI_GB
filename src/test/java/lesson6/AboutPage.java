package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutPage {
    WebDriver driver;

    private final String AboutUsXpath = "/html/body/div[1]/div[2]/ul[1]/li[2]/a";

    public AboutPage(WebDriver driver) {
        this.driver = driver;
    }

    public AboutPage ClickAbout(){
        WebElement AboutUs = driver.findElement(By.xpath(AboutUsXpath));
        AboutUs.click();
        return this;
    }
}

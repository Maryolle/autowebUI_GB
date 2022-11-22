package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    private final String loginPanelXPath = "//*[@id=\"loginPanel\"]/form/div[1]/input";
    private final String passwordPanelXPath = "//*[@id=\"loginPanel\"]/form/div[2]/input";
    private final String loginButtonXPath = "//*[@id=\"loginPanel\"]/form/div[3]/input";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage TypeLogin(){
        WebElement Login = driver.findElement(By.xpath(loginPanelXPath));
        Login.sendKeys("john");
        return this;
    }

    public LoginPage TypePassword(){
        WebElement Password = driver.findElement(By.xpath(passwordPanelXPath));
        Password.sendKeys("demo");
        return this;
    }

    public LoginPage PressLoginButton(){
        WebElement LogButton = driver.findElement(By.xpath(loginButtonXPath));
        LogButton.click();
        return this;
    }
}

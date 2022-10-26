package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetupBrowserExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions Options = new ChromeOptions();
        Options.addArguments("--headless");
        Options.addArguments("--disable-notifications");
        Options.addArguments("user-agent=Googlebot/2.1(+https://google.com/bot.html)");

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        Thread.sleep(5000);
        driver.quit();
    }
}

package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleniumStart {
    public static void main(String[] args) throws InterruptedException {
       System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        driver.quit();

        WebDriverManager.chromedriver().setup();
        driver.get("https://google.com");
        long millis;
        Thread.sleep(Duration.ofMillis(5000));

        driver.quit();
    }
}


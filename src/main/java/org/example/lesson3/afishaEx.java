package org.example.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class afishaEx {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.afisha.ru/");
        Thread.sleep(5000);

        WebElement inputSearch = webDriver.findElement(By.xpath("//input[@placeholder='Событие, актер, место']"));
        inputSearch.sendKeys("брат");
        webDriver.findElement(By.xpath("//div[.='Брат']")).click();
        Thread.sleep(5000);

        webDriver.quit();
    }
}
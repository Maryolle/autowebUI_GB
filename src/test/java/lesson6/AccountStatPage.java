package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountStatPage {
    WebDriver driver;

    private final String FirstAccountXpath = "//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a";
    private final String SearchBarXpath = "//*[@id=\"search-0-searchInput\"]";
    private final String SelectMonthXpath = "//*[@id=\"month\"]/option[2]";
    private final String SelectTypeXpath = "//*[@id=\"transactionType\"]/option[3]";
    private final String GetStatisticsXpath = "//*[@id=\"rightPanel\"]/div/div[2]/form/table/tbody/tr[3]/td[2]/input";
    public String number;


    public AccountStatPage(WebDriver driver) {
        this.driver = driver;
    }

    public AccountStatPage FirstAccountGet(){
        WebElement FirstAccount = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(FirstAccountXpath)));
        number = FirstAccount.getText();
        FirstAccount.click();
        return this;
    }

    public AccountStatPage SelectMonth(){
        WebElement SelectMonth = driver.findElement(By.xpath(SelectMonthXpath));
        SelectMonth.click();
        return this;
    }

    public AccountStatPage SelectType(){
        WebElement SelectType = driver.findElement(By.xpath(SelectTypeXpath));
        SelectType.click();
        return this;
    }
}

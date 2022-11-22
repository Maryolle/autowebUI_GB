package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForumPage {
    WebDriver driver;

    private final String ForumXpath = "/html/body/div[2]/div/ul[1]/li[6]/a";
    private final String SearchBarXpath = "//*[@id=\"search-0-searchInput\"]";
    private String SearchBarInputText;
    private final String SearchButtonXpath = "//*[@id=\"search-0-searchButton\"]";


    public ForumPage(WebDriver driver, String inputText) {
        SearchBarInputText = inputText;
        this.driver = driver;
    }

    public ForumPage ClickForumButton(){
        WebElement Forum = driver.findElement(By.xpath(ForumXpath));
        Forum.click();
        return this;
    }

    public ForumPage TypeSearchText(){
        WebElement SearchBar = driver.findElement(By.xpath(SearchBarXpath));
        SearchBar.sendKeys(SearchBarInputText);
        return this;
    }

    public ForumPage ClickSearchButton(){
        WebElement SearchButton = driver.findElement(By.xpath(SearchButtonXpath));
        SearchButton.click();
        return this;
    }
}

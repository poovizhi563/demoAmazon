package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class searchPage {
    WebDriver driver;

    By searchBox = By.id("twotabsearchtextbox");
    By searchBtn = By.className("s-entity-default-pane-container");

    public searchPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void searchBook(String bookName) {
        driver.findElement(searchBox).sendKeys(bookName);
        driver.findElement(searchBtn).click();
    }

    public boolean verifyResults() {
        return driver.getTitle().contains("Amazon");
    }
}

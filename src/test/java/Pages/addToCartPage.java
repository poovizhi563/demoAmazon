package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class addToCartPage {
    WebDriver driver;

    By addToCartBtn = By.id("add-to-cart-button");
    By addedText = By.xpath("//h1[contains(text(),'Added to Cart')]");

    public addToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCart() {
        driver.findElement(addToCartBtn).click();
    }

    public boolean verifyProductAdded() {
        return driver.getPageSource().contains("Added to Cart");
    }
}

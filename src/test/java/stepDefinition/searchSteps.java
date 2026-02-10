package stepDefinition;
import Pages.addToCartPage;
import Pages.searchPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class searchSteps
{
    WebDriver driver;
    searchPage amazonPage;
    addToCartPage cartPage;

    @Given("I launch Amazon website {string} link")
    public void i_launch_amazon_website_link(String url)
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        amazonPage=new searchPage(driver);
        cartPage =new addToCartPage(driver);
    }
    @When("I search {string} book")
    public void i_search_book(String book)
    {
        amazonPage.searchBook(book);
    }

    @Then("I get search result")
    public void i_get_search_result()
    {
        assertTrue(amazonPage.verifyResults());
    }

    @Then("I add product to cart")
    public void i_add_product_to_cart() {
        cartPage.clickAddToCart();
    }

    @Then("I see {string}")
    public void i_see(String string) {
        assertTrue(cartPage.verifyProductAdded());
        driver.quit();
    }
}

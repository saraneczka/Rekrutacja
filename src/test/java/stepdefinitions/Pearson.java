package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class Pearson {

    private WebDriver driver;

    @Before
    public void beforeScenario() {
        System.setProperty("webdriver.chrome.driver", "/Users/annasarnowska/IdeaProjects/Pluto/src/test/resources/webdriver/chromedrivermac");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void afterScenario() {
        driver.close();
    }

    @Given("I am on the Pearson start page")
    public void iVisitPluto() {
        driver.get("https://pearson.com");

    }
    @When("Close cookies")
        public void closeCookies(){driver.findElement(By.id("cookie-notification-policy-accept-continue")).click();}

    @And("I click on search field")
    public void clickSearchfield(){driver.findElement(By.id("search-box-input")).click();}
    @And("Type in Spanish")
    public void typeIn(){ driver.findElement(By.id("search-box-input")).sendKeys("spanish");}
    @And("Click on search button")
    public void clickSearch(){driver.findElement(By.cssSelector(".search-box-icon")).click();}
    @And("Click on Next button")
    public void clickNext(){driver.findElement(By.linkText("Next")).click();}
    @Then("Click on 3rd link on the list")
    public void clickResult() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='productItem__name'])[3]")));
        driver.findElement(By.xpath("(//a[@class='productItem__name'])[3]")).click();

    }
}






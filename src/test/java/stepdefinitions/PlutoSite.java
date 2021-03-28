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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PlutoSite {

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

    @Given("I am on the Pluto start page")
    public void iVisitPluto() {
        driver.get("https://pluto-customer-web-app-staging.herokuapp.com/tailored-annual-or-single");
    }

    @When("Close popup")
    public void clickExit() {
        driver.findElement(By.cssSelector(".jss267 > path")).click();
    }

    @And("I click on Annual cover")
    public void clickAnnual() {
        driver.findElement(By.cssSelector(".jss283:nth-child(2) .jss247")).click();
    }

    @And("I click on logo site")
    public void clickLogoSite() {
        driver.findElement(By.xpath("//div[@class='logo-quote-container']//div//*[@class='injected-svg']")).click();
    }

    @And("I click on take me home")
    public void clickTakeMeHome() {
        driver.findElement(By.xpath("//button[contains(.,'Take me home')]")).click();
    }

    @And("I click on Next button")
    public void clickNextButton() {

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Next')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
    }

    @And("I type name and age")
    public void typeNameAge() {

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));
        driver.findElement(By.xpath("//input[@id='username']")).click();
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Ania Sarnowska");
        driver.findElement(By.id("age")).click();
        driver.findElement(By.id("age")).sendKeys("29");
    }


    @And("I choose I do have pre-existing medical conditions")
    public void chooseHaveMedicalConditions() {

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(.,'I do have a pre-existing medical condition')]")));
        driver.findElement(By.xpath("//label[contains(.,'I do have a pre-existing medical condition')]")).click();
    }

    @And("I choose I don't have pre-existing medical conditions")
    public void chooseHaveNotMedicalConditions() {

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//label[contains(@class,'jss7427')])[1]")));
        driver.findElement(By.xpath("(//label[contains(@class,'jss7427')])[1]")).click();
    }


    @Then("Click on Our definition of a partner")
    public void clickPartner() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".jss629")));
        driver.findElement(By.cssSelector(".jss629")).click();
        WebElement element = driver.findElement((By.cssSelector(".jss266")));
        Assert.assertTrue(element.isDisplayed());
    }

    @Then("We aren’t able to offer cover to people with pre-existing medical conditions")
    public void notAbleToOfferCover() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(.,'We aren’t able to offer cover to people with pre-existing medical conditions. We’re working hard to change this.')]")));
        WebElement element = driver.findElement((By.xpath("//p[contains(.,'We aren’t able to offer cover to people with pre-existing medical conditions. We’re working hard to change this.')]")));
        Assert.assertTrue(element.isDisplayed());
    }

    @Then("Page title should start with \"(.*)\"")
    public void checkTitle(String titleStartsWith) {
        new WebDriverWait(driver,10L).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().startsWith(titleStartsWith);
            }
        });

    }
}
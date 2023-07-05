package StepDefinitions;
import Base.DriverFactory;
import POM.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.io.IOException;




public class LoginSteps extends DriverFactory {
    private WebDriver driver = getDriver();
    private LoginPage loginPage;
    public LoginSteps() throws IOException {
        loginPage = new LoginPage(driver);
    }


    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
        driver = getDriver();
        driver.get(getUrl());
    }


    @When("I enter a username {}")
    public void i_enter_a_uniq_username(String username) {
        loginPage.getUserName().sendKeys(username);
    }


    @And("I enter a password {word}")
    public void i_enter_a_password_webdriver123(String password) {
        loginPage.getPassword().sendKeys(password);
    }
    @And("I click on the login button")
    public void i_click_on_the_login_button() throws InterruptedException {
        loginPage.getClickBtn().click();
        Thread.sleep(3000);
    }
    @Then("I should be presented with the successful login message")
    public void i_should_be_presented_with_the_successful_login_message() throws InterruptedException {
        Assert.assertEquals(driver.switchTo().alert().getText(), "validation succeeded", "Login Not Successful");
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        cleanupDriver();
    }


    @Then("I should be presented with the unsuccessful login message")
    public void i_should_be_presented_with_the_unsuccessful_login_message() throws InterruptedException {
        Assert.assertEquals(driver.switchTo().alert().getText(), "validation failed", "Login Successful");
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        cleanupDriver();
    }


    @Then("I should be presented with the following login validation message {}")
    public void i_should_be_presented_with_the_following_login_validation_message(String loginValidationMessage) throws InterruptedException {
        Assert.assertEquals(driver.switchTo().alert().getText(), loginValidationMessage, "Login Successful");
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        cleanupDriver();
    }
}

package StepDefinitions;
import Base.DriverFactory;
import POM.ContactPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.io.IOException;


public class Contact_Us_Steps extends DriverFactory{
    private WebDriver driver = getDriver();
    private ContactPage contactPage;

    public Contact_Us_Steps(){
        super();
        contactPage = new ContactPage(driver); // buradaki driver onceden tanimlanmali

    }


    //Unique Data
    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() throws IOException {
        driver = getDriver(); // chrome
        driver.get(getUrl()); // http://www.webdriveruniversity.com/
    }
    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        contactPage.getName().sendKeys ("Test" + generateRandomNumber(5));
    }
    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        contactPage.getLastName().sendKeys("Tester" + generateRandomNumber(5));
    }
    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        contactPage.getEmail().sendKeys("Tester"+ generateRandomString(5) + "@example.com");
    }
    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        contactPage.getMessage().sendKeys("I Am a super Tester!  " + generateRandomString(50));
    }



    // Specific Data
    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name_joe(String firstName) {
        contactPage.getName().sendKeys(firstName + generateRandomNumber(3));
    }
    @When("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name_blogs(String lastName) {
        contactPage.getLastName().sendKeys(lastName + generateRandomNumber(3));
    }
    @When("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address_joe_blogs123_mail_com(String email) {
        contactPage.getEmail().sendKeys(email + generateRandomNumber(3) + "@mail.com");
    }
    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String message) {
        contactPage.getMessage().sendKeys(message + " " + generateRandomString(10));
    }



    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
        contactPage.getSubmitBtn().click();
    }
    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() throws InterruptedException {
        Assert.assertEquals(contactPage.getSuccessMsg().getText(), "Thank You for your Message!", "Message did not match");
        Thread.sleep(1000);
        cleanupDriver();
    }





}

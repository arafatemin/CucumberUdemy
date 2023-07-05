package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPage {
    public WebDriver driver;

    By name = By.cssSelector("form#contact_form > input[name='first_name']");
    By lastname = By.cssSelector("form#contact_form > input[name='last_name']");
    By email = By.cssSelector("form#contact_form > input[name='email']");
    By message = By.cssSelector("form#contact_form > textarea[name='message']");

    By submitBtn = By.cssSelector("div#form_buttons > input:nth-of-type(2)");
    By successMsg = By.cssSelector("div#contact_reply > h1");


/*
    By name = By.cssSelector("form#contact_form > input[name='first_name']");
    By lastname = By.cssSelector("form#contact_form > input[name='last_name']");
    By email = By.cssSelector("form#contact_form > input[name='email']");
    By message = By.cssSelector("form#contact_form > textarea[name='message']");

    By submitBtn = By.cssSelector("div#form_buttons > input:nth-of-type(2)");
    By successMsg = By.xpath("//div[@id='main']/div[@class='inner']//h3[.='Thank you for your mail!']");

*/







    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getName(){
        return driver.findElement(name);
    }

    public WebElement getLastName(){
        return driver.findElement(lastname);
    }

    public WebElement getEmail(){
        return driver.findElement(email);
    }

    public WebElement getMessage(){
        return driver.findElement(message);
    }

    public WebElement getSubmitBtn(){
        return driver.findElement(submitBtn);
    }

    public WebElement getSuccessMsg(){
        return driver.findElement(successMsg);
    }
}

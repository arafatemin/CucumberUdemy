package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;
    By username = By.cssSelector("[placeholder='Username']");
    By password = By.cssSelector("[placeholder='Password']");
    By clickBtn = By.cssSelector("button#login-button");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUserName(){
        return driver.findElement(username);
    }
    public WebElement getPassword(){
        return driver.findElement(password);
    }

    public WebElement getClickBtn(){
        return driver.findElement(clickBtn);
    }



}

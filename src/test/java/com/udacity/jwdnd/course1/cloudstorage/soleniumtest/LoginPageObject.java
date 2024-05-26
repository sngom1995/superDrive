package com.udacity.jwdnd.course1.cloudstorage.soleniumtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {

    @FindBy(id = "inputUsername")
    public WebElement usernameInput;

    @FindBy(id = "inputPassword")
    public WebElement passwordInput;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(id = "signup-page")
    public WebElement signupPage;

    public WebDriver driver;
    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void authenticate(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void goToSignupPage() {
        signupPage.click();
    }
}

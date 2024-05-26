package com.udacity.jwdnd.course1.cloudstorage.soleniumtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPageObject {

    @FindBy(id = "inputFirstName" )
    public WebElement firstNameInput;

    @FindBy(id = "inputLastName")
    public WebElement lastNameInput;

    @FindBy(id = "inputUsername")
    public WebElement usernameInput;

    @FindBy(id = "inputPassword")
    public WebElement passwordInput;

    @FindBy(id = "buttonSignUp")
    public WebElement signUpButton;

    private WebDriver driver;

    public SignUpPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createUser(String username, String password, String firstName, String lastName) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signUpButton.click();
    }
}

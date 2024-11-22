package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By userNameLocator = By.cssSelector("#rightPanel h1");
    private By successfulMessageLocator = By.cssSelector("#rightPanel p");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getUserName(){
        return driver.findElement(userNameLocator).getText();
    }
    public String getSuccessfulMessage(){
        return driver.findElement(successfulMessageLocator).getText();
    }

}

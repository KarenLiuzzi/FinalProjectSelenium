package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SignUp {
    private WebDriver driver;

    private By firstNameLocator = By.id("customer.firstName");
    private By lastNameLocator = By.id("customer.lastName");
    private By addressLocator = By.id("customer.address.street");
    private By cityLocator = By.id("customer.address.city");
    private By stateLocator = By.id("customer.address.state");
    private By zipCodeLocator = By.id("customer.address.zipCode");
    private By phoneLocator = By.id("customer.phoneNumber");
    private By ssnLocator = By.id("customer.ssn");
    private By userNameLocator = By.id("customer.username");
    private By passwordLocator = By.id("customer.password");
    private By confirmPasswordLocator = By.id("repeatedPassword");
    private By registerButtonLocator = By.cssSelector("input[value=\"Register\"]");
    private By labelRegisterFormLocator = By.cssSelector("tbody tr b");
    private By fieldsRegisterFormLocator = By.cssSelector("tbody tr input:not([type=\"submit\"])");

    public SignUp(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstName(String firstName) {
        driver.findElement(firstNameLocator).sendKeys(firstName);
    }
    public void setLastName(String lastName) {
        driver.findElement(lastNameLocator).sendKeys(lastName);
    }
    public void setAddress(String address) {
        driver.findElement(addressLocator).sendKeys(address);
    }
    public void setCity(String city) {
        driver.findElement(cityLocator).sendKeys(city);
    }
    public void setState(String state) {
        driver.findElement(stateLocator).sendKeys(state);
    }
    public void setZipCode(String zipCode) {
        driver.findElement(zipCodeLocator).sendKeys(zipCode);
    }
    public void setPhone(String phone) {
        driver.findElement(phoneLocator).sendKeys(phone);
    }
    public void setSsn(String ssn) {
        driver.findElement(ssnLocator).sendKeys(ssn);
    }
    public void setUserName(String userName) {
        driver.findElement(userNameLocator).sendKeys(userName);
    }

    public void setPassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }
    public void setConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordLocator).sendKeys(confirmPassword);
    }

    public HomePage clickRegisterWithAllValidData(){
        driver.findElement(registerButtonLocator).click();
        return new HomePage(driver);
    }

    public List<String> getLabelRegisterFormLocator() {
        List<String> labelsRegisterForm = new ArrayList<String>();
        List<WebElement> labelElements = driver.findElements(labelRegisterFormLocator);
        for(WebElement labelElement :labelElements ) {
            labelsRegisterForm.add(labelElement.getText());
        }
        return labelsRegisterForm;
    }

    public List<WebElement> getFieldsRegisterFormLocator() {
        return driver.findElements(fieldsRegisterFormLocator);
    }
}
